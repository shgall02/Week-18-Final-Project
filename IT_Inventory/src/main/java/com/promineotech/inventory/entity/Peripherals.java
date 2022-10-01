package com.promineotech.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
  public class Peripherals {
  private Long periphId;
  private Long userId;
  private String device;
  private String make;
  private String model;
}
