package com.cscn.uranus.fdep.processor.repo;

import com.cscn.uranus.fdep.processor.entity.Flowcontrolmsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowcontrolmsgRepo extends JpaRepository<Flowcontrolmsg, String> {}
