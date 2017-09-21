package com.cscn.uranus.fdep.processor.listener;

import com.cscn.uranus.fdep.annotation.ExcludeFromTest;
import com.cscn.uranus.fdep.config.service.FdepConfigManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;

@ExcludeFromTest
@Configuration
@EnableJms
public class FlightmsgListenerConfig implements JmsListenerConfigurer {
  private FdepConfigManager fdepConfigManager;
  private FlightmsgListener flightmsgListener;

  public FlightmsgListenerConfig(
      FdepConfigManager fdepConfigManager, FlightmsgListener flightmsgListener) {
    this.fdepConfigManager = fdepConfigManager;
    this.flightmsgListener = flightmsgListener;
  }

  @Override
  public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
    String queueName = this.fdepConfigManager.getFlightmsgQueueName();
    SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
    endpoint.setId("flightmsgEndpoint");
    endpoint.setDestination(queueName);
    endpoint.setMessageListener(this.flightmsgListener);
    registrar.registerEndpoint(endpoint);
  }
}
