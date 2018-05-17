package com.thirdeye.util;

import org.apache.commons.text.StringSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TeStringUtils {

  private static final Logger logger = LoggerFactory.getLogger(TeStringUtils.class);

  public static final String VARIABLE_PREFIX = "${{";
  public static final String VARIABLE_SUFFIX = "}}";

  public static String processStringTemplate(String templateString, Map<String, Object> data) {
    StringSubstitutor sub = new StringSubstitutor(data, VARIABLE_PREFIX, VARIABLE_SUFFIX);
    return sub.replace(templateString);
  }

  public static void main(String[] args) {
    Map<String, Object> data = new HashMap<String, Object>() {
      {
        put("ticketId", null);
        put("oldTicketSection", "Chat History");
      }
    };

    System.out.println(processStringTemplate("%20%20${{oldTicketSection}}%20%20section.%20Mention%20#${{ticketId}}%20for%20reference.%20Thanks,%20Joe", data));
  }
}