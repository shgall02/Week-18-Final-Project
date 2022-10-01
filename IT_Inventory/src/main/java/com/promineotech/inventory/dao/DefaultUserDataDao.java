package com.promineotech.inventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.promineotech.inventory.entity.UserData;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultUserDataDao implements UserDataDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 
  
  public Optional<UserData> fetchUserData(Long userId) {
    log.info("DAO: userId={}", userId);
    
    String sql = ""
        +"Select * "
        +"FROM UserData "
        +"WHERE userId = :userId";
    
    Map<String, Object> params = new HashMap<>();
    params.put("userId", userId);
    return Optional.ofNullable( 
        jdbcTemplate.query(sql, params, new UserDataResultSetExtractor()));
  }
      class UserDataResultSetExtractor implements ResultSetExtractor<UserData> {

    
    @Override
    public UserData extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      return UserData.builder()
          .userId(rs.getLong("userId"))
          .firstName(rs.getString("firstName"))
          .lastName(rs.getString("lastName"))
          .location(rs.getString("location"))
          .build();
          
    }     
    
  }
  
  public Optional<UserData> createUserData(Long userId, String firstName, String lastName, String location) {
    log.info("DAO: userId={}, firstName={}, lastName={}, location={}", userId, firstName, lastName, location);
    SqlParams params = generateInsertSql(userId, firstName, lastName, location);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(UserData.builder()
        .userId(userId)
        .firstName(firstName)
        .lastName(lastName)
        .location(location)
        .build());
  }
  

  public Optional<UserData> updateUserData(Long userId, String firstName, String lastName, String location){
    log.info("DAO: userId={}, firstName={}, lastName={}, location={}", userId, firstName, lastName, location);
    SqlParams params = generateUpdateSql(userId, firstName, lastName, location);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(UserData.builder()
        .userId(userId)
        .firstName(firstName)
        .lastName(lastName)
        .location(location)
        .build());
  }
   
  private SqlParams generateInsertSql(Long userId, String firstName, String lastName, String location)  {
    log.info("DAO: userId={}, firstName={}, lastName={}, location={}", userId, firstName, lastName, location);
    String sql = ""
        + "Insert into UserData(userId, firstName, lastName, location) "
        + "Values (:userId, :firstName, :lastName, :location)";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("userId", userId);
    params.source.addValue("firstName", firstName);
    params.source.addValue("lastName", lastName);
    params.source.addValue("location", location);
    return params;
  }

  class SqlParams{
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();  
    }
  
  private SqlParams generateUpdateSql(Long userId, String firstName, String lastName, String location) {
    log.info("DAO: userId={}, firstName={}, lastName={}, location={}", userId, firstName, lastName, location);
    String sql = ""
        + "Update userData "
        + "Set firstName = :firstName, lastName = :lastName, location = :location "
        + "Where userId = :userId";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("firstName", firstName);
    params.source.addValue("lastName", lastName);
    params.source.addValue("location", location);
    Map<String, Object> params2 = new HashMap<>();
    params2.put("userId", userId);
    params.source.addValues(params2);
    return params;
  }

  public Optional<UserData> deleteUserData(Long userId){
    SqlParams params = generateDeleteSql(userId);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(UserData.builder()
        .userId(userId)
        .build());
}
  
  private SqlParams generateDeleteSql(Long userId) {
      String sql = ""
          + "DELETE FROM userData "
          + "Where userId = :userId";
          
      SqlParams params = new SqlParams();
      params.sql = sql;
      Map<String, Object> params2 = new HashMap<>();
      params2.put("userId", userId);
      params.source.addValues(params2);
      return params;
      
  }
}



