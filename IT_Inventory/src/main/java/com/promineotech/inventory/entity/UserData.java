package com.promineotech.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
  public class UserData {
  private Long userId;
  private String firstName;
  private String lastName;
  private String location;
}
