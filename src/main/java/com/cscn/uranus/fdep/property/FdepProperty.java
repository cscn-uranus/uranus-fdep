package com.cscn.uranus.fdep.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "uranus.fdep")
public class FdepProperty {
  private String host;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }
}
