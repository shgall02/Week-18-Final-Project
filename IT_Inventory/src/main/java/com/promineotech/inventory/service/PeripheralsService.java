package com.promineotech.inventory.service;

import java.util.Optional;
import com.promineotech.inventory.entity.Peripherals;


public interface PeripheralsService {

  Optional<Peripherals> fetchPeripherals(Long periphId);

  Optional<Peripherals> createPeripherals(Long periphId, Long userId, String device, String make, String model);
  
  Optional<Peripherals> updatePeripherals(Long periphId, Long userId, String device, String make, String model);

  Optional<Peripherals> deletePeripherals(Long periphId);




}
