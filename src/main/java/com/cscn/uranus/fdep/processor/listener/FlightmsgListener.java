package com.cscn.uranus.fdep.processor.listener;

import com.cscn.uranus.fdep.annotation.ExcludeFromTest;
import com.cscn.uranus.fdep.processor.entity.Flightmsg;
import com.cscn.uranus.fdep.processor.serivce.FlightmsgManager;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@ExcludeFromTest
@Component
public class FlightmsgListener implements MessageListener {

  private FlightmsgManager flightmsgManager;

  public FlightmsgListener(FlightmsgManager flightmsgManager) {
    this.flightmsgManager = flightmsgManager;
  }

  @Async
  public void onMessage(Message msg) {
    TextMessage textMessage = (TextMessage) msg;
    String flightmsgDomText = null;
    try {
      flightmsgDomText = textMessage.getText();
    } catch (JMSException e) {
      e.printStackTrace();
    }

    // 将消息传入processor处理（同步 or 异步）
    //
    if (flightmsgDomText != null) {
      Flightmsg flightmsg = new Flightmsg();
      flightmsg.setDomText(flightmsgDomText);
      this.flightmsgManager.save(flightmsg);
    }
  }
}
