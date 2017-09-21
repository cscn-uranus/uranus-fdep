package com.cscn.uranus.fdep.processor.repo;

import com.cscn.uranus.fdep.processor.entity.Flightmsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightmsgRepo extends JpaRepository<Flightmsg, String> {

}
