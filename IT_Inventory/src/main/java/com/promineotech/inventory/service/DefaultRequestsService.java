package com.promineotech.inventory.service;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.inventory.dao.RequestsDao;
import com.promineotech.inventory.entity.Requests;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRequestsService implements RequestsService {

  @Autowired
  private RequestsDao requestsDao;

  @Transactional
  @Override
  public Optional<Requests> fetchRequests(Long requestId) {
    log.info("The fetchRequests method was called with requestId={}", requestId);
    return requestsDao.fetchRequests(requestId);
  }

  @Override
  public Optional<Requests> createRequests(Date shipDate, Date receiveDate, Date returnDate,Long requestId, Long userId, Long typeId, int quantity) {
    log.info("The createRequests method was called with shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", requestId, userId, typeId, quantity, shipDate, receiveDate);
    return requestsDao.createRequests(shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
  }

  @Override
  public Optional<Requests> updateRequests(Date shipDate, Date receiveDate, Date returnDate,Long requestId, Long userId, Long typeId, int quantity) {
    log.info("The updateRequests method was called with shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", requestId, userId, typeId, quantity, shipDate, receiveDate);
       return requestsDao.updateRequests(shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
  }

  @Override
  public Optional<Requests> deleteRequests(Long requestId) {
    log.info("The deleteRequests method was called with requestId={}", 
        requestId);
    return requestsDao.deleteRequests(requestId);
  }

  }

  
  
  
 
  

 
  

  

  
  

