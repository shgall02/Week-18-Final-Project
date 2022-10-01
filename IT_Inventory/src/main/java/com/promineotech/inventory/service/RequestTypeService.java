package com.promineotech.inventory.service;

import java.util.Optional;
import com.promineotech.inventory.entity.RequestType;

public interface RequestTypeService {

  Optional<RequestType> fetchRequestType(Long typeId);

  Optional<RequestType> createRequestType(Long typeId, String typeName);

  Optional<RequestType> updateRequestType(Long typeId, String typeName);

  Optional<RequestType> deleteRequestType(Long typeId);


}
