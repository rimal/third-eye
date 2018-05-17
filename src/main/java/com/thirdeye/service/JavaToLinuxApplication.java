package com.thirdeye.service;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;

public class JavaToLinuxApplication {

  public static String callShell(String[] args) throws IOException {

    if (args == null) {
      return "No arguments passed";
    }
    if (args.length < 1) {
      return "No arguments passed";
    }
    for (int i = 0; i < args.length; i++) {
      System.out.println(args[i]);
    }
    //String[] command = {"sh", "t1.sh"};
    String[] command = {"python", "test_t.py", "rahul_t"};
    ProcessBuilder probuilder = new ProcessBuilder(args);
    //You can set up your work directory
    //probuilder.directory(new File(System.getProperty("user.home")));
    //System.out.println(System.getProperty("user.home"));
//    probuilder.directory(new File(System.getProperty("user.home")));
    //probuilder.directory(new File("/Users/rahul"));
    //probuilder.directory(new File("/home/ubuntu/motiondetector/codeferm"));
    probuilder.directory(new File("/Users/rahul/project/hackathon/motiondetector/codeferm"));

    Process process = probuilder.start();

    //Read out dir output
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    System.out.printf("Output of running %s is:\n",
        Arrays.toString(args));
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }

    //Wait to get exit value
    try {
      int exitValue = process.waitFor();
      System.out.println("\n\nExit Value is " + exitValue);
      if (exitValue == 0) {
        return "success";
      } else {
        return "fail";
      }

    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return "fail";
  }

  public static String generateImageFromVideo(String videoPath, String outputImagePath) {
    // ffmpeg -i /tmp/motion-09-51-45.avi -vf 'select=eq(n\,0)' -q:v 1 /tmp/output.jpg
    if (StringUtils.isBlank(outputImagePath)) {
      outputImagePath = "/tmp/initFrame.jpg";
    }
    if (StringUtils.isBlank(videoPath)) {
      videoPath = "/tmp/motion-09-51-45.avi";
    }
    String[] command = {"sh", "generateImageFromVideo.sh", videoPath, outputImagePath};
    try {
      System.out.println("calling shell with command::" + command);
      return callShell(command);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "fail";
  }

  public static String generateMask(String x, String y, String width, String height) {
    // ffmpeg -i /tmp/motion-09-51-45.avi -vf 'select=eq(n\,0)' -q:v 1 /tmp/output.jpg
    if (StringUtils.isBlank(x) || StringUtils.isBlank(y) || StringUtils.isBlank(width) || StringUtils.isBlank(height)) {
      return "one of the parameters is blank";
    }

    String[] command = {"python", "img_try.py", x, y, width, height};
    //String[] command = {"python", "test_t.py", "rahul_t"};
    try {
      return callShell(command);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "fail";
  }

  public static String generateFinalVideo() {
    // ffmpeg -i /tmp/motion-09-51-45.avi -vf 'select=eq(n\,0)' -q:v 1 /tmp/output.jpg

    String[] command = {"python", "videoloop.py"};
    try {
      System.out.println("calling shell with command::" + command);
      return callShell(command);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "fail";
  }


  public static void main(String[] args) {

    String[] command = {"sh test.sh", "1"};
    try {
      //System.out.println(callShell(command));
      //System.out.println(generateImageFromVideo(null, null));
      System.out.println(generateMask("20", "30", "200", "200"));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
