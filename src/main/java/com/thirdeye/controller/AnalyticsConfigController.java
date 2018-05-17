package com.thirdeye.controller;

import com.thirdeye.constants.PropertyKey;
import com.thirdeye.exception.TeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@RequestMapping("/analytics-config")
public class AnalyticsConfigController {

  private static final Logger logger = LoggerFactory.getLogger(AnalyticsConfigController.class);

  @Autowired
  private Environment env;

  @RequestMapping("")
  public String analyticsConfig(Model model) {
    getFirstFrameFileFromDisk();
    model.addAttribute("firstFrameFile", "/analytics-config/first-frame-file");
    return "analyticsConfig";
  }

  @RequestMapping(value = "/first-frame-file")
  @ResponseBody
  public byte[] getFirstFrameFile() throws IOException {
    return Files.readAllBytes(getFirstFrameFileFromDisk().toPath());
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