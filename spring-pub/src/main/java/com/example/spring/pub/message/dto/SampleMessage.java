package com.example.spring.pub.message.dto;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class SampleMessage {
  private String sender;
  private String context;
}
