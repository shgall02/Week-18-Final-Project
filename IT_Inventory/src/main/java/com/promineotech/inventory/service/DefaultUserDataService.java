package com.promineotech.inventory.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.inventory.dao.UserDataDao;
import com.promineotech.inventory.entity.UserData;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultUserDataService implements UserDataService {
  
  @Autowired
  private UserDataDao userDataDao;
  
  @Transactional
  @Override
  public Optional<UserData> fetchUserData(Long userId) {
    log.info("The fetchRequests method was called with userId={}", userId);
    return null;
  }

  @Override
  public Optional<UserData> createUserData(Long userId, String firstName, String lastName, String location) {
    log.info("The createRequests method was called with userId={}, firstName={}, lastName={}, location={}", firstName, lastName, location);
    return userDataDao.createUserData(userId, firstName, lastName, location);
  }

  @Override
  public Optional<UserData> updateUserData(Long userId, String firstName, String lastName, String location) {
    log.info("The updateRequests method was called with firstName={}, lastName={}, location={}", firstName, lastName, location);
    return userDataDao.updateUserData(userId, firstName, lastName, location);  
    }

  @Override
  public Optional<UserData> deleteUserData(Long userId) {
    log.info("The delete Requests method was called with userId={}", userId);
    return userDataDao.deleteUserData(userId);  
  }

}
