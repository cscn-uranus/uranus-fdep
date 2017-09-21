package com.cscn.uranus.fdep.config.service;

import com.cscn.uranus.fdep.config.FdepConfigEnum;
import com.cscn.uranus.fdep.config.entity.FdepConfig;
import com.cscn.uranus.fdep.config.repo.FdepConfigRepo;
import com.cscn.uranus.fdep.exception.FdepException;
import com.cscn.uranus.fdep.exception.FdepExceptionEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FdepConfigManager {
  private final FdepConfigRepo fdepConfigRepo;

  public FdepConfigManager(FdepConfigRepo fdepConfigRepo) {
    this.fdepConfigRepo = fdepConfigRepo;
    this.initDefaultConfig();
  }

  public void initDefaultConfig() {
    this.initDefaultFlightmsgQueueConfig();
    this.initDefaultFlowcontrolmsgQueueConfig();
  }

  private void initDefaultFlightmsgQueueConfig() {
    long length = this.fdepConfigRepo.findByCode(FdepConfigEnum.FLIGHTMSG_QUEUE.getCode()).size();
    if (length < 1) {
      FdepConfig config = new FdepConfig();
      config.setCode(FdepConfigEnum.FLIGHTMSG_QUEUE.getCode());
      config.setValue(FdepConfigEnum.FLIGHTMSG_QUEUE.getValue());
      this.fdepConfigRepo.save(config);
    }
  }

  private void initDefaultFlowcontrolmsgQueueConfig() {
    long length =
        this.fdepConfigRepo.findByCode(FdepConfigEnum.FLOWCONTROLMSG_QUEUE.getCode()).size();
    if (length < 1) {
      FdepConfig config = new FdepConfig();
      config.setCode(FdepConfigEnum.FLOWCONTROLMSG_QUEUE.getCode());
      config.setValue(FdepConfigEnum.FLOWCONTROLMSG_QUEUE.getValue());
      this.fdepConfigRepo.save(config);
    }
  }

  public void create(String code, String value) {
    FdepConfig config = new FdepConfig();
    config.setCode(code);
    config.setValue(value);
    this.fdepConfigRepo.save(config);
  }

  public void updateByCode(String code, String value) {
    long length = this.fdepConfigRepo.findByCode(code).size();
    if (length > 1) {
      throw new FdepException(FdepExceptionEnum.MULTIPLE_ERROR);
    } else if (length < 1) {
      throw new FdepException(FdepExceptionEnum.NONE_ERROR);
    } else {
      FdepConfig config = this.fdepConfigRepo.findByCode(code).get(0);
      config.setValue(value);
      this.fdepConfigRepo.save(config);
    }
  }

  public String findByCode(String code) {
    String value;
    long length = this.fdepConfigRepo.findByCode(code).size();
    if (length > 1) {
      value = null;
    } else if (length < 1) {
      value = null;
    } else {
      FdepConfig config = this.fdepConfigRepo.findByCode(code).get(0);
      value = config.getValue();
    }
    return value;
  }

  public void setFlightmsgQueueName(String queueName) {
    String code = FdepConfigEnum.FLIGHTMSG_QUEUE.getCode();
    this.updateByCode(code, queueName);
  }

  public String getFlightmsgQueueName() {
    String code = FdepConfigEnum.FLIGHTMSG_QUEUE.getCode();
    return this.findByCode(code);
  }

  public void setFlowcontrolmsgQueueName(String queueName) {
    String code = FdepConfigEnum.FLOWCONTROLMSG_QUEUE.getCode();
    this.updateByCode(code, queueName);
  }

  public String getFlowcontrolmsgQueueName() {
    String code = FdepConfigEnum.FLOWCONTROLMSG_QUEUE.getCode();
    return this.findByCode(code);
  }
}
