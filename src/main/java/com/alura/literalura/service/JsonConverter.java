package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter implements IDataConverter {
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public <T> T getData(String json, Class<T> entity) {
    try {
      return objectMapper.readValue(json, entity);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
