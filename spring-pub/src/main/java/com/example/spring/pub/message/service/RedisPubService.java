package com.example.spring.pub.message.service;

import com.example.spring.pub.message.dto.SampleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPubService {
  private final RedisTemplate<String, Object> redisTemplate;

  public void sendMessage(SampleMessage sampleMessage) {
    redisTemplate.convertAndSend("boro-topic", sampleMessage);
  }
}
