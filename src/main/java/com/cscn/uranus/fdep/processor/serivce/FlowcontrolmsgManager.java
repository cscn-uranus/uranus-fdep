package com.cscn.uranus.fdep.processor.serivce;


import com.cscn.uranus.fdep.processor.entity.Flowcontrolmsg;
import com.cscn.uranus.fdep.processor.repo.FlowcontrolmsgRepo;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlowcontrolmsgManager {
  private final FlowcontrolmsgRepo flowcontrolmsgRepo;

  public FlowcontrolmsgManager(FlowcontrolmsgRepo flowcontrolmsgRepo) {
    this.flowcontrolmsgRepo = flowcontrolmsgRepo;
  }

  public void save(Flowcontrolmsg flowcontrolmsg) {
    this.flowcontrolmsgRepo.save(flowcontrolmsg);
  }
  public List<Flowcontrolmsg> findAll() {
    return this.flowcontrolmsgRepo.findAll();
  }
  public void deleteAll() {
    this.flowcontrolmsgRepo.deleteAll();
  }
}
