package com.cscn.uranus.fdep.processor.serivce;


import com.cscn.uranus.fdep.processor.entity.Flightmsg;
import com.cscn.uranus.fdep.processor.repo.FlightmsgRepo;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightmsgManager {
  private final FlightmsgRepo flightmsgRepo;

  public FlightmsgManager(FlightmsgRepo flightmsgRepo) {
    this.flightmsgRepo = flightmsgRepo;
  }

  public void save(Flightmsg flightmsg) {
    this.flightmsgRepo.save(flightmsg);
  }

  public List<Flightmsg> findAll() {
    return this.flightmsgRepo.findAll();
  }

  public void delete(Flightmsg flightmsg) {
    this.flightmsgRepo.delete(flightmsg);
  }

  public void deleteAll() {
    this.flightmsgRepo.deleteAll();
  }
}
