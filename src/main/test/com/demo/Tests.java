package com.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class Tests {

  @Autowired
  private ObjectMapper mapper;
  
  @BeforeEach
  void init() {
  }

  @Test
  @DisplayName("l")
  void convert_lhr_interface_to_asset_dto_millis_success() {
  }

  @Test
  @DisplayName("")
  void convert_lhr_interface_to_asset_dto_seconds_success() {
  }

  @Test
  @DisplayName("")
  void convert_ham_interface_to_asset_dto_success() throws JsonProcessingException {
  }

}