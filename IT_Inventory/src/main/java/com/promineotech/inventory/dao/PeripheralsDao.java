package com.promineotech.inventory.dao;

import java.util.Optional;
import com.promineotech.inventory.entity.Peripherals;

public interface PeripheralsDao {

  Optional<Peripherals> fetchPeripherals(Long periphId);

  Optional<Peripherals> createPeripherals(Long periphId, Long userId, String device, String make, String model);
  
  Optional<Peripherals> updatePeripherals(Long periphId, Long userId, String device, String make, String model);

  Optional<Peripherals> deletePeripherals(Long periphId);
  

  




}
