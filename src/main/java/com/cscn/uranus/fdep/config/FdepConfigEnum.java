package com.cscn.uranus.fdep.config;

public enum FdepConfigEnum {
  FLIGHTMSG_QUEUE("FlightmsgQueueName", "CENTER2REGION.TEST.FLIGHTS.QUEUE"),
  FLOWCONTROLMSG_QUEUE("FlowcontrolmsgQueueName", "CENTER2REGION.TEST.FLOWCONTROLS.QUEUE");

  private String code;
  private String value;

  FdepConfigEnum(String code, String value) {
    this.code = code;
    this.value = value;
  }

  public String getCode() {
    return code;
  }

  public String getValue() {
    return value;
  }
}
