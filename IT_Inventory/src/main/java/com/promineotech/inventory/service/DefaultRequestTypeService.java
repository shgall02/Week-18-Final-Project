package com.promineotech.inventory.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.inventory.dao.RequestTypeDao;
import com.promineotech.inventory.entity.RequestType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRequestTypeService implements RequestTypeService {

  @Autowired
  private RequestTypeDao requestTypeDao;

  @Transactional
  @Override
  public Optional<RequestType> fetchRequestType(Long typeId) {
    log.info("The fetchRequests method was called with typeId={}", typeId);
    return requestTypeDao.fetchRequestType(typeId);
  }

  @Override
  public Optional<RequestType> createRequestType(Long typeId, String typeName) {
    log.info("The createRequests method was called with typeId={}, typeName={}", typeId, typeName);
    return requestTypeDao.createRequestType( typeId, typeName);
  }

  @Override
  public Optional<RequestType> updateRequestType(Long typeId, String typeName) {
    log.info("The updateRequests method was called with typeId={}, typeName={}", typeId, typeName);
    return requestTypeDao.updateRequestType(typeId, typeName);
  }

  @Override
  public Optional<RequestType> deleteRequestType(Long typeId) {
    log.info("The deleteRequests method was called with typeId={}, typeName={}", typeId);
    return requestTypeDao.deleteRequestType(typeId);
  }

  }

  
  
  
 
  

 
  

  

  
  

