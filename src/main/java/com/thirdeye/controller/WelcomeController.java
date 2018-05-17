package com.thirdeye.controller;

import com.thirdeye.constants.PropertyKey;
import com.thirdeye.constants.VideoProcessingConstants;
import com.thirdeye.service.JavaToLinuxApplication;
import com.thirdeye.util.TeStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@Controller
public class WelcomeController {

  private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

  @Autowired
  private Environment env;

  @RequestMapping("/")
  public String welcome() {
    return "welcome";
  }

  @PostMapping("/upload-video")
  public String handleVideoUpload(@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
    File file = new File("/tmp/third-eye/" + multipartFile.getOriginalFilename());
    boolean parentPathCreated = file.getParentFile().mkdirs();
    if (parentPathCreated) {
      logger.info("Parent path created automatically");
    }

    boolean fileCreated = file.createNewFile();
    if (!fileCreated) {
      logger.info("File: " + file.getAbsolutePath() + " already exists");
    }

    //transfer file to disk
    multipartFile.transferTo(file);
    logger.info("File: " + multipartFile.getOriginalFilename() + " saved to disk");

    //write updated motion detector ini to disk
    String motionDetectorIniFilePath = env.getProperty(PropertyKey.MOTION_DETECTOR_INI_FILE);
    File motionDetectorIniFile = new File(motionDetectorIniFilePath);
    boolean parentPathForMotionDetectorIniFilePathCreated = motionDetectorIniFile.getParentFile().mkdirs();
    if (parentPathForMotionDetectorIniFilePathCreated) {
      logger.info("Parent path for motion detector ini file created automatically");
    }

    Path path = Paths.get(motionDetectorIniFilePath);
    byte[] strToBytes = TeStringUtils.processStringTemplate(VideoProcessingConstants.MOTION_DETECTOR_INI_TEMPLATE, new HashMap<String, Object>() {{
      put("url", file.getAbsolutePath());
    }}).getBytes();
    Files.write(path, strToBytes);
    logger.info("Motion detector iniFile: " + motionDetectorIniFilePath + " saved to disk");

    //get first frame from video
    String output = JavaToLinuxApplication.generateImageFromVideo(file.getAbsolutePath(), env.getProperty(PropertyKey.VIDEO_FIRST_FRAME_FILE));
    logger.info("First image generation: " + output);

    redirectAttributes.addFlashAttribute("message",
        "You successfully uploaded " + multipartFile.getOriginalFilename() + "!");

    return "redirect:/analysis/config";
  }
}