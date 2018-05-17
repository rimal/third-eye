package com.thirdeye.controller;

import com.thirdeye.service.HelloApplication;
import com.thirdeye.service.JavaToLinuxApplication;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloRestController {

  private static final Logger logger = LoggerFactory.getLogger(HelloRestController.class);


  @RequestMapping("/hello-matlab")
  public String helloMatlab(@RequestParam(value = "input", defaultValue = "Third Eye") String input) {
    return HelloApplication.runHelloWorld(input);
  }

  @RequestMapping("/hello")
  public String hello() {
    return "Hello! aaa";
  }

  @RequestMapping("/runCommand")
  public String runCommand(@RequestParam(value = "command", defaultValue = "sh test.sh") String command) {

    if (StringUtils.isBlank(command)) {
      return "Empty Command not acceptable";
    }
    try {
      JavaToLinuxApplication.callShell(command.split(" "));

    } catch (IOException e) {
      e.printStackTrace();
    }
    return "Hellos!!!";
  }

  @RequestMapping("/generateImageFromVideo")
  public String generateImageFromVideo(@RequestParam(value = "videoPath", required = false) String videoPath,
                                       @RequestParam(value = "outputImagePath", required = false) String outputImagePath) {
    return JavaToLinuxApplication.generateImageFromVideo(null, null);
  }

  @RequestMapping("/runCode")
  public String runCode() {
    return JavaToLinuxApplication.generateFinalVideo();
  }

  public static void main(String[] args) {
    String[] command = "sh test.sh".split(" ");
    try {
      System.out.println(JavaToLinuxApplication.callShell(command));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

 /* @RequestMapping("/generateImageFromVideo")
  public String generateMask(@RequestParam(value = "x", required = false) String x,
                             @RequestParam(value = "y", required = false) String y,
                             @RequestParam(value = "width", required = false) String ) {
    return JavaToLinuxApplication.generateImageFromVideo(null, null);
  }

  public static void main(String[] args) {
    String[] command = "sh test.sh".split(" ");
    try {
      System.out.println(JavaToLinuxApplication.callShell(command));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }*/


}