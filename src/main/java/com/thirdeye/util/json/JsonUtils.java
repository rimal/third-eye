package com.thirdeye.util.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thirdeye.config.databind.TeObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

  private static final ObjectMapper mapper;
  private static final JsonFactory jsonFactory;

  static {
    mapper = new TeObjectMapper();
    jsonFactory = mapper.getFactory();
  }

  public static String getJson(Object object) {
    if (null == object) {
      return null;
    }

    try {
      return mapper.writeValueAsString(object);
    } catch (Exception e) {
      logger.error("Error encountered while getting json for " + object.getClass(), e);
    }

    return null;
  }
}