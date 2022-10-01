package com.promineotech.inventory.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.inventory.entity.RequestType;
import com.promineotech.inventory.service.RequestTypeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultRequestTypeController implements RequestTypeController{
  
  @Autowired
  private RequestTypeService requestTypeService;

  @Override
  public Optional<RequestType> fetchRequestType(Long typeId) {
    log.info("typeId={}", typeId);    
    return requestTypeService.fetchRequestType(typeId);
  }

  @Override
  public Optional<RequestType> createRequestType(Long typeId, String typeName) {
    log.info("typeId={}, typeName={}", typeId, typeName);    
    return requestTypeService.createRequestType(typeId, typeName);
  }

  @Override
  public Optional<RequestType> updateRequestType(Long typeId, String typeName) {
    log.info("typeId={}, typeName={}", typeId, typeName);    
    return requestTypeService.updateRequestType(typeId, typeName);
  }

  @Override
  public Optional<RequestType> deleteRequestType(Long typeId) {
    log.info("typeId={}, typeName={}", typeId);    
    return requestTypeService.deleteRequestType(typeId);
  }

  }


