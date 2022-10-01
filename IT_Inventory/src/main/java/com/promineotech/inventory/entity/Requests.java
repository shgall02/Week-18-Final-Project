package com.promineotech.inventory.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
  public class Requests {
  private Long requestId;
  private Long userId;
  private Long typeId; 
  private int quantity;
  private Date shipDate;
  private Date receiveDate;
  private Date returnDate;
  }

  

