package com.promineotech.inventory.service;

import java.util.Date;
import java.util.Optional;
import com.promineotech.inventory.entity.Requests;


public interface RequestsService {

  Optional<Requests> fetchRequests(Long requestId);

  Optional<Requests> createRequests(Date shipDate, Date receiveDate, Date returnDate, Long requestId, Long userId, Long typeId, int quantity);
  
  Optional<Requests> updateRequests(Date shipDate, Date receiveDate, Date returnDate, Long requestId, Long userId, Long typeId, int quantity);

  Optional<Requests> deleteRequests(Long requestId);








  


  









  

}
