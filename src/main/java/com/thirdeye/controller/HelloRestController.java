package com.thirdeye.controller;

import com.thirdeye.service.HelloApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

  private static final Logger logger = LoggerFactory.getLogger(HelloRestController.class);


  @RequestMapping("/hello-matlab")
  public String helloMatlab(@RequestParam(value = "input", defaultValue = "Third Eye") String input) {
    return HelloApplication.runHelloWorld(input);
  }

  @RequestMapping("/hello")
  public String hello() {
    return "Hello!";
  }
}