package com.promineotech.inventory.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.inventory.dao.PeripheralsDao;
import com.promineotech.inventory.entity.Peripherals;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPeripheralsService implements PeripheralsService {

  @Autowired
  private PeripheralsDao peripheralsDao;
  
  @Transactional
  @Override
  public Optional<Peripherals> fetchPeripherals(Long periphId) {
    log.info("The fetchPeripherals method was called with periphId={} ", periphId);
    return peripheralsDao.fetchPeripherals(periphId);
  }

  @Override
  public Optional<Peripherals> createPeripherals(Long periphId, Long userId, String device, String make, String model) {
    log.info("The createPeripherals method was called with periphId={}, userId={}, device={}, make={}, model={}", periphId, userId, device, make, model);
    return peripheralsDao.createPeripherals(periphId, userId, device, make, model);
  }
  
  @Override
  public Optional<Peripherals> updatePeripherals(Long periphId, Long userId, String device, String make, String model) {
    log.info("The updatePeripherals method was called with periphId={}, userId={}, device={}, make={}, model={}", periphId, userId, device, make, model);
    return peripheralsDao.updatePeripherals(periphId, userId, device, make, model);
  }

  @Override
  public Optional<Peripherals> deletePeripherals(Long periphId) {
    log.info("The deletePeripherals method was called with periphId={}", periphId);
    return peripheralsDao.deletePeripherals(periphId);
  }

  }

