package com.thirdeye.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class WelcomeController {

  private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

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

    multipartFile.transferTo(file);

    logger.info("File: " + multipartFile.getOriginalFilename() + " saved to disk");

    redirectAttributes.addFlashAttribute("message",
        "You successfully uploaded " + multipartFile.getOriginalFilename() + "!");

    return "redirect:/";
  }
}