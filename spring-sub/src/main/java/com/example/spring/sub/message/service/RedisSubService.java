package com.example.spring.sub.message.service;

import com.example.spring.sub.message.dto.SampleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSubService implements MessageListener {

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public void onMessage(Message message, byte[] pattern) {

    try {
      log.info(message.toString());
      SampleMessage msg = mapper.readValue(message.getBody(), SampleMessage.class);
      log.info("SampleMessage" + msg.toString());
    } catch (IOException e) {
      log.error("IOException", e);
    }
  }
}
