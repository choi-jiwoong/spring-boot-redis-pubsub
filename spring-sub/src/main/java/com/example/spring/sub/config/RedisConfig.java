package com.example.spring.sub.config;

import com.example.spring.sub.message.dto.SampleMessage;
import com.example.spring.sub.message.service.RedisSubService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

public class RedisConfig {
  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    return new LettuceConnectionFactory();
  }

  //redisTemplate 설정
  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory());
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(SampleMessage.class));
    return redisTemplate;
  }

  //리스너어댑터 설정
  @Bean
  MessageListenerAdapter messageListenerAdapter() {
    return new MessageListenerAdapter(new RedisSubService());
  }

  //컨테이너 설정
  @Bean
  RedisMessageListenerContainer redisContainer() {
    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(redisConnectionFactory());
    container.addMessageListener(messageListenerAdapter(), topic());
    return container;
  }

  @Bean
  ChannelTopic topic() {
    return new ChannelTopic("boro-topic");
  }

}
