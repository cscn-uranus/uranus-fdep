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
public class FlowcontrolmsgListenerConfig implements JmsListenerConfigurer {
  private final FdepConfigManager fdepConfigManager;
  private final FlowcontrolmsgListener flowcontrolmsgListener;

  public FlowcontrolmsgListenerConfig(
      FdepConfigManager fdepConfigManager, FlowcontrolmsgListener flowcontrolmsgListener) {
    this.fdepConfigManager = fdepConfigManager;
    this.flowcontrolmsgListener = flowcontrolmsgListener;
  }

  @Override
  public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
    String queueName = this.fdepConfigManager.getFlowcontrolmsgQueueName();
    SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
    endpoint.setId("flowcontrolmsgEndpoint");
    endpoint.setDestination(queueName);
    endpoint.setMessageListener(this.flowcontrolmsgListener);
    registrar.registerEndpoint(endpoint);
  }
}
