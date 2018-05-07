package com.thirdeye.service;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import hello_world.HelloWorldMatlab;

public class HelloApplication {

  public static String runHelloWorld(String input) {
    String output = null;
    MWNumericArray n = null;
    Object[] result = null;
    HelloWorldMatlab matlabClassInstance = null;

    try {
      matlabClassInstance = new HelloWorldMatlab();

      result = matlabClassInstance.hello_world(1, input);
      output = result[0].toString();
      System.out.println(output);
    } catch (Exception e) {
      System.out.println("Exception: " + e);
    } finally {
      MWArray.disposeArray(n);
      MWArray.disposeArray(result);
      matlabClassInstance.dispose();
    }

    return output;
  }

  /*private static void runSum() {
MWNumericArray n = null;
    Object[] result = null;
    dum_pro.Class1 matlabClassInstance = null;

    try {
      matlabClassInstance = new dum_pro.Class1();

      result = matlabClassInstance.dum_pro(2, 3, 5);
      System.out.println(result[0]);
    } catch (Exception e) {
      System.out.println("Exception: " + e.toString());
    } finally {
      MWArray.disposeArray(n);
      MWArray.disposeArray(result);
      matlabClassInstance.dispose();
    }

  }*/

  public static void main(String[] args) {
    runHelloWorld("Rimal");
  }


/*public static void main(String[] args) {
    System.out.println("hello");
  }*/

}