package com.promineotech.inventory.dao;

import java.util.Optional;
import com.promineotech.inventory.entity.UserData;

public interface UserDataDao {

  Optional<UserData> fetchUserData(Long userId);

  Optional<UserData> createUserData(Long userId, String firstName, String lastName, String location);
  
  Optional<UserData> updateUserData(Long userId, String firstName, String lastName, String location);

  Optional<UserData> deleteUserData(Long userId);

  


}
