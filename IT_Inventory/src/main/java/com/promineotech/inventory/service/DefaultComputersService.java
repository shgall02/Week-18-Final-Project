package com.promineotech.inventory.service;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.inventory.dao.ComputersDao;
import com.promineotech.inventory.entity.Computers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultComputersService implements ComputersService {

  @Autowired
  private ComputersDao computersDao;
  
  @Transactional
  @Override
  public Optional<Computers> fetchComputers(Long compId) {
    log.info("The fetchComputers method was called with compId={}", compId);
    return computersDao.fetchComputers(compId);
  }

  @Override
  public Optional<Computers> createComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model) {
    log.info("The createComputers method was called with expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);
    return computersDao.createComputers(expiration, compId, userId, serviceTag, make, model);
  }

  @Override
  public Optional<Computers> updateComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model) {
    log.info("The updateComputers method was called with expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);
    return computersDao.updateComputers(expiration, compId, userId, serviceTag, make, model);
  }

  @Override
  public Optional<Computers> deleteComputers(Long compId) {
    log.info("The deleteComputers method was called with compId={}", compId);
    return computersDao.deleteComputers(compId);
  }

}
