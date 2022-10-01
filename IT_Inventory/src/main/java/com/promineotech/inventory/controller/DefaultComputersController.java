package com.promineotech.inventory.controller;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.inventory.entity.Computers;
import com.promineotech.inventory.service.ComputersService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultComputersController implements ComputersController {

  @Autowired
  private ComputersService computersService;
  
  
  @Override
  public Optional<Computers> fetchComputers(Long compId) {
    log.info("compId={}", compId);
    return computersService.fetchComputers(compId);
    
  }
  
  @Override
  public Optional<Computers> createComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model) {
    log.info("expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);
    return computersService.createComputers(expiration, compId, userId, serviceTag, make, model);
  }

  @Override
  public Optional<Computers> updateComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model) {
    log.info("expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);    
    return computersService.updateComputers(expiration, compId, userId, serviceTag, make, model);
  }

  @Override
  public Optional<Computers> deleteComputers(Long compId) {
    log.info("compId={}", compId);    
    return computersService.deleteComputers(compId);
  }

}
