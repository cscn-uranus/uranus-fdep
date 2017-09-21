package com.cscn.uranus.fdep.config.repo;

import com.cscn.uranus.fdep.config.entity.FdepConfig;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FdepConfigRepo extends JpaRepository<FdepConfig, Long> {
  List<FdepConfig> findByCode(String code);
}
