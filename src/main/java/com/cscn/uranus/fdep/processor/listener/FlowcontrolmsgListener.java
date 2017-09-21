package com.cscn.uranus.fdep.processor.listener;

import com.cscn.uranus.fdep.annotation.ExcludeFromTest;
import com.cscn.uranus.fdep.processor.entity.Flowcontrolmsg;
import com.cscn.uranus.fdep.processor.serivce.FlowcontrolmsgManager;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@ExcludeFromTest
@Component
public class FlowcontrolmsgListener implements MessageListener {

  private FlowcontrolmsgManager flowcontrolmsgManager;

  public FlowcontrolmsgListener(
      FlowcontrolmsgManager flowcontrolmsgManager) {
    this.flowcontrolmsgManager = flowcontrolmsgManager;
  }

  @Async
  public void onMessage(Message msg) {
    TextMessage textMessage = (TextMessage) msg;
    String flowcontrolDomText = null;
    try {
      flowcontrolDomText = textMessage.getText();
    } catch (JMSException e) {
      e.printStackTrace();
    }

    // 将消息传入processor处理（同步 or 异步）
    //
    if (flowcontrolDomText != null) {
      Flowcontrolmsg flowcontrolmsg = new Flowcontrolmsg();
      flowcontrolmsg.setDomText(flowcontrolDomText);
      this.flowcontrolmsgManager.save(flowcontrolmsg);
    }
  }
}
