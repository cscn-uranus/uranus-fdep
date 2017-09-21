package com.cscn.uranus.fdep.exception;

public class FdepException extends RuntimeException {
  private String code;

  public FdepException(FdepExceptionEnum fdepExceptionEnum) {
    super(fdepExceptionEnum.getMsg());
    this.code = fdepExceptionEnum.getCode();
  }

  public String getCode() {
    return code;
  }
}
