package com.promineotech.inventory.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.inventory.entity.UserData;
import com.promineotech.inventory.service.UserDataService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUserDataController implements UserDataController {
  
  @Autowired
  private UserDataService userDataService;

  @Override
  public Optional<UserData> fetchUserData(Long userId) {
    log.info("userId={}", userId);    
    return userDataService.fetchUserData(userId);
  }

  @Override
  public Optional<UserData> createUserData(Long userId, String firstName, String lastName, String location) {
    log.info("userId={}, firstName={}, lastName={}, location={}", userId, firstName, lastName, location);    
    return userDataService.createUserData(userId, firstName, lastName, location);
  }

  @Override
  public Optional<UserData> updateUserData(Long userId, String firstName, String lastName, String location) {
    log.info("userId={}, firstName={}, lastName={}, location={}", userId, firstName, lastName, location);    
    return userDataService.updateUserData(userId, firstName, lastName, location);
  }

  @Override
  public Optional<UserData> deleteUserData(Long userId) {
    log.info("userId={}", userId);    
    return userDataService.deleteUserData(userId);
  }

 
  }


