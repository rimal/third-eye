package com.thirdeye.controller;

import com.thirdeye.constants.PropertyKey;
import com.thirdeye.dto.AnalysisConfigDataDTO;
import com.thirdeye.exception.TeNotFoundException;
import com.thirdeye.service.JavaToLinuxApplication;
import com.thirdeye.util.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {

  private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);

  @Autowired
  private Environment env;

  @RequestMapping("/config")
  public String analysisConfig(Model model) {
    getFirstFrameFileFromDisk();
    model.addAttribute("firstFrameFile", "/analysis/first-frame-file");
    return "analyticsConfig";
  }

  @RequestMapping(value = "/data", method = RequestMethod.POST)
  public String submitConfigData(AnalysisConfigDataDTO analysisConfigDataDTO, RedirectAttributes redirectAttributes) {
    logger.info("Analysis config data::::" + JsonUtils.getJson(analysisConfigDataDTO));

    //Generate Mask
    String output = JavaToLinuxApplication.generateMask(analysisConfigDataDTO.getX().toString(), analysisConfigDataDTO.getY().toString(), analysisConfigDataDTO.getWidth().toString(), analysisConfigDataDTO.getHeight().toString());
    logger.info("Mask generation::::" + output);

    //Call video processing
    String videoOutput = JavaToLinuxApplication.generateMultipleVideos();
    logger.info("video processing called::::" + videoOutput);

    //Call GENERATE FINAL OUTPUT
    String finalOutput = JavaToLinuxApplication.generateFinalOutput();
    logger.info("video generateFinalOutput::::" + finalOutput);


    redirectAttributes.addFlashAttribute("message", "Video processed!");
    return "redirect:/analysis/output";
  }

  @RequestMapping(value = "/first-frame-file")
  @ResponseBody
  public byte[] getFirstFrameFile() throws IOException {
    return Files.readAllBytes(getFirstFrameFileFromDisk().toPath());
  }

  @RequestMapping("/output")
  public String analysisOutput(Model model) {
    model.addAttribute("outputVideo", "/analysis/output-video");
    return "detectionOutput";
  }

  @RequestMapping(value = "/output-video")
  @ResponseBody
  public byte[] getOutputVideo() throws IOException {
    String outputVideoFilePath = env.getProperty(PropertyKey.OUTPUT_VIDEO_FILE);
    logger.info("Getting output video from: " + outputVideoFilePath);

    File file = new File(outputVideoFilePath);
    if (!file.exists()) {
      throw new TeNotFoundException("Could not find the output video file");
    }

    return Files.readAllBytes(file.toPath());
  }

  private File getFirstFrameFileFromDisk() {
    String firstFrameFilePath = env.getProperty(PropertyKey.VIDEO_FIRST_FRAME_FILE);
    logger.info("Getting first frame file from: " + firstFrameFilePath);

    File file = new File(firstFrameFilePath);
    if (!file.exists()) {
      throw new TeNotFoundException("Could not find the first frame file");
    }

    return file;
  }
}