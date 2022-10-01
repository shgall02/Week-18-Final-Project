package com.promineotech.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
  public class RequestType {
  private Long typeId;
  private String typeName;

  }

  

