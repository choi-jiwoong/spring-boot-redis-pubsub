package com.example.spring.pub.message.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class SampleMessage {
  private String sender;
  private String context;
}
