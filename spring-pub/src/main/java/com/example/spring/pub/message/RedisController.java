package com.example.spring.pub.message;

import com.example.spring.pub.message.dto.SampleMessage;
import com.example.spring.pub.message.service.RedisPubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

  private final RedisPubService redisPubService;

  @PostMapping("api/chat")
  public String pubSub(@RequestBody SampleMessage sampleMessage) {
    //메시지 보내기
    redisPubService.sendMessage(sampleMessage);

    return "success";
  }
}
