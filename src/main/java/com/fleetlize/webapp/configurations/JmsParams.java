package com.fleetlize.webapp.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fleetlize.jms.topic")
@Getter
@Setter
public class JmsParams {
  private String carCreation;
}
