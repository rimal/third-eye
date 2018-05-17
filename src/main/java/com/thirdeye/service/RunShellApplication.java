package com.thirdeye.service;

import com.thirdeye.util.StreamGobbler;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executors;

public class RunShellApplication {


  public static void main(String[] args) {
    System.out.println("hello");
    try {
      System.out.println(Runtime.getRuntime().exec("ls -l"));

      /*ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1", "myArg2");
      Map<String, String> env = pb.environment();
      env.put("VAR1", "myValue");
      env.remove("OTHERVAR");
      env.put("VAR2", env.get("VAR1") + "suffix");
      pb.directory(new File("myDir"));
      Process p = pb.start();*/

      boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

      ProcessBuilder builder = new ProcessBuilder();
      if (isWindows) {
        builder.command("cmd.exe", "/c", "dir");
      } else {
        //builder.command("perl", "test.pl");
        builder.command("sh", "test.sh");
        //builder.command("python", "test.py", "rahul");

      }
      builder.directory(new File(System.getProperty("user.home")));
      System.out.println("user home is ::::" + builder.directory());
      Process process = builder.start();
      StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
      Executors.newSingleThreadExecutor().submit(streamGobbler);
      int exitCode = process.waitFor();
      assert exitCode == 0;


    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {

    }

  }
}

