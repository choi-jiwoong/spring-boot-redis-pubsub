package com.example.spring.pub.message.service;

import com.example.spring.pub.message.dto.SampleMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisPubService {
  private final RedisTemplate<String, Object> redisTemplate;

  public void sendMessage(SampleMessage sampleMessage) {

    log.info("sendMessage : {}", sampleMessage);
    redisTemplate.convertAndSend("boro-topic", sampleMessage);
  }
}
