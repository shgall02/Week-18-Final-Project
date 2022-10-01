package com.promineotech.inventory.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.inventory.entity.Peripherals;
import com.promineotech.inventory.service.PeripheralsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPeripheralsController implements PeripheralsController {
 
  @Autowired
  private PeripheralsService peripheralsService;

  public Optional<Peripherals> fetchPeripherals(Long periphId) {
     log.info("periphId={}", periphId);
    return peripheralsService.fetchPeripherals(periphId);
  }

  @Override
  public Optional<Peripherals> createPeripherals(Long periphId, Long userId, String device, String make, String model) {
    log.info("periphId={}, userId={}, device={}, make={}, model={}", periphId, device, make, model);
    return peripheralsService.createPeripherals(periphId, userId, device, make, model);
  }

  @Override
  public Optional<Peripherals> updatePeripherals(Long periphId, Long userId, String device, String make, String model) {
    log.info("periphId={}, userId={}, device={}, make={}, model={}", periphId, device, make, model);
    return peripheralsService.updatePeripherals(periphId, userId, device, make, model);
  }

  @Override
  public Optional<Peripherals> deletePeripheral(Long periphId) {
    log.info("periphId={}", periphId);
    return peripheralsService.deletePeripherals(periphId);
  }

    }
  


