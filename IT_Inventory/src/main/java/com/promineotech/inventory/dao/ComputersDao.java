package com.promineotech.inventory.dao;

import java.util.Date;
import java.util.Optional;
import com.promineotech.inventory.entity.Computers;

public interface ComputersDao {

  Optional<Computers> fetchComputers(Long compId);

  Optional<Computers> createComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model);
  
  Optional<Computers> updateComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model);
  
  Optional<Computers> deleteComputers(Long compId);



  



  
  

 

  

  

  



}
