package com.cscn.uranus.fdep.exception;

public enum FdepExceptionEnum {
  UNKNOWN_ERROR("FCE -1", "FCE: UNKNOWN ERROR"),
  NONE_ERROR("FCE 1", "FCE: CAN NOT FIND MATCHED RECORD"),
  MULTIPLE_ERROR("FCE 2", "FCE: EXPECT ONE, BUT FOUND MULTIPLE RECORDS"),
  SUCCESS("FCE 100", "FCE: SUCCESS");
  private String code;
  private String msg;

  FdepExceptionEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
