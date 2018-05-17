package com.thirdeye.config.databind;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TeObjectMapper extends ObjectMapper {

  public TeObjectMapper() {
    this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    this.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
  }
}