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
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.inventory.entity.Peripherals;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPeripheralsDao implements PeripheralsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 
  
  public Optional<Peripherals> fetchPeripherals(Long periphId) {
    log.info("DAO: periphId={}", periphId);
    
    String sql = ""
        +"Select * "
        +"FROM Peripherals "
        +"WHERE periphId = :periphId";
    
    Map<String, Object> params = new HashMap<>();
    params.put("periphId", periphId);
    return Optional.ofNullable( 
        jdbcTemplate.query(sql, params, new PeripheralsResultSetExtractor()));
  }
      class PeripheralsResultSetExtractor implements ResultSetExtractor<Peripherals> {

    
    @Override
    public Peripherals extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      return Peripherals.builder()
          .periphId(rs.getLong("periphId"))
          .userId(rs.getLong("userId"))
          .device(rs.getString("device"))
          .make(rs.getString("make"))
          .model(rs.getString("model"))
          .build();
    }     
    
  }
  
  public Optional<Peripherals> createPeripherals(Long periphId, Long userId, String device, String make, String model) {
    log.info("DAO: periphId={}, userId={}, device={}, make={}, model={}", periphId, userId, device, make, model);
    SqlParams params = generateInsertSql(periphId, userId, device, make, model);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    return Optional.of(Peripherals.builder()
        .periphId(periphId)
        .userId(userId)
        .device(device)
        .make(make)
        .model(model)
        .build());
  }
  @Transactional
  public Optional<Peripherals> updatePeripherals(Long periphId, Long userId, String device, String make, String model){
    log.info("DAO: periphId={}, userId={}, device={}, make={}, model={}", periphId, userId, device, make, model);
    SqlParams params = generateUpdateSql(periphId, userId, device, make, model);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Peripherals.builder()
        .periphId(periphId)
        .userId(userId)
        .device(device)
        .make(make)
        .model(model)
        .build());
  }
   
  private SqlParams generateInsertSql(Long periphId, Long userId, String device, String make, String model)  {
    log.info("DAO: periphId={}, userId={}, device={}, make={}, model={}", periphId, userId, device, make, model);
    String sql = ""
        + "Insert into Peripherals(periphId, userId, device, make, model) "
        + "Values (:periphId, :userId, :device, :make, :model )";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("periphId", periphId);
    params.source.addValue("userId", userId);
    params.source.addValue("device", device);
    params.source.addValue("make", make);
    params.source.addValue("model", model);
    return params;
  }

  class SqlParams{
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();  
    }
  
  private SqlParams generateUpdateSql(Long periphId, Long userId, String device, String make, String model) {
    log.info("DAO: periphId={}, userId={}, device={}, make={}, model={}", periphId, userId, device, make, model);
    String sql = ""
        + "Update Peripherals "
        + "Set userId = :userId, device = :device, make = :make, model = :model "
        + "Where periphId = :periphId";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("userId", userId);
    params.source.addValue("device", device);
    params.source.addValue("make", make);
    params.source.addValue("model", model);
    Map<String, Object> params2 = new HashMap<>();
    params2.put("periphId", periphId);
    params.source.addValues(params2);
    return params;
  }  
  
  @Override
  public Optional<Peripherals> deletePeripherals(Long periphId){
    SqlParams params = generateDeleteSql(periphId);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Peripherals.builder()
        .periphId(periphId)
        .build());    
  }

  private SqlParams generateDeleteSql(Long periphId) {
      String sql = ""
          + "DELETE FROM Peripherals "
          + "Where periphId = :periphId";
      SqlParams params = new SqlParams();
      params.sql = sql;
      Map<String, Object> params2 = new HashMap<>();
      params2.put("periphId", periphId);
      params.source.addValues(params2);
      return params;
  }
}

