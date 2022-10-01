package com.promineotech.inventory.controller;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.inventory.entity.Requests;
import com.promineotech.inventory.service.RequestsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultRequestsController implements RequestsController {
  
  @Autowired
  private RequestsService requestsService;

  @Override
  public Optional<Requests> fetchRequests(Long requestId) {
    log.info("requestId={}", requestId);
    return requestsService.fetchRequests(requestId);
  }
 
  @Override
  public Optional<Requests> createRequests(Date shipDate, Date receiveDate, Date returnDate,Long requestId, Long userId, Long typeId, int quantity) {
    log.info("shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", requestId, userId, typeId, quantity, shipDate, receiveDate);    
    return requestsService.createRequests(shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity); 
  }
  
  @Override
  public Optional<Requests> updateRequests(Date shipDate, Date receiveDate, Date returnDate, Long requestId, Long userId, Long typeId, int quantity) {
    log.info("shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", requestId, userId, typeId, quantity, shipDate, receiveDate);    
    return requestsService.updateRequests( shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity); 
  }
  @Override
  public Optional<Requests> deleteRequests(Long requestId) {
    log.info("requestId={}", requestId);    
    return requestsService.deleteRequests(requestId); 
  }


  }

 
  

  
  
   
  

