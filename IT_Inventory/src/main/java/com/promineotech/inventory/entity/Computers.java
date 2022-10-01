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
  public class Computers {
  private Long compId;
  private Long userId;
  private String serviceTag;
  private String make;
  private String model;
  private Date expiration;

  }
 

