package com.promineotech.inventory.dao;

import java.util.Optional;
import com.promineotech.inventory.entity.RequestType;

public interface RequestTypeDao {

  Optional<RequestType> fetchRequestType(Long typeId);

  Optional<RequestType> createRequestType(Long typeId, String typeName);
  
  Optional<RequestType> updateRequestType(Long typeId, String typeName);

  Optional<RequestType> deleteRequestType(Long typeId);


  


}
