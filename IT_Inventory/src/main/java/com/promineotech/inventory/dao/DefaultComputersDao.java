package com.promineotech.inventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
import com.promineotech.inventory.entity.Computers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultComputersDao implements ComputersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 
  
  public Optional<Computers> fetchComputers(Long compId) {
    log.info("DAO: compId={}", compId);
    
    String sql = ""
        +"Select * "
        +"FROM Computers "
        +"WHERE compId = :compId";
    
    Map<String, Object> params = new HashMap<>();
    params.put("compId", compId);
    return Optional.ofNullable( 
        jdbcTemplate.query(sql, params, new ComputersResultSetExtractor()));
  }
      class ComputersResultSetExtractor implements ResultSetExtractor<Computers> {

    
    @Override
    public Computers extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      return Computers.builder()
          .compId(rs.getLong("compId"))
          .userId(rs.getLong("userId"))
          .serviceTag(rs.getString("serviceTag"))
          .make(rs.getString("make"))
          .model(rs.getString("model"))
          .expiration(rs.getDate("expiration"))
          .build();
    }     
    
  }
  
  public Optional<Computers> createComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model) {
    log.info("DAO: expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);
    SqlParams params = generateInsertSql(expiration, compId, userId, serviceTag, make, model);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    return Optional.of(Computers.builder()
        .compId(compId)
        .userId(userId)
        .serviceTag(serviceTag)
        .make(make)
        .model(model)
        .expiration(expiration)
        .build());
  }
  @Transactional
  public Optional<Computers> updateComputers(Date expiration, Long compId, Long userId, String serviceTag, String make, String model){
    log.info("DAO: expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);
    SqlParams params = generateUpdateSql(expiration, compId, userId, serviceTag, make, model);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Computers.builder()
        .compId(compId)
        .userId(userId)
        .serviceTag(serviceTag)
        .make(make)
        .model(model)
        .expiration(expiration)
        .build());
  }
   
  private SqlParams generateInsertSql(Date expiration, Long compId, Long userId, String serviceTag, String make, String model)  {
    log.info("DAO: expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);
    String sql = ""
        + "Insert into Computers(compId, userId, serviceTag, make, model, expiration) "
        + "Values (:compId, :userId, :serviceTag, :make, :model, :expiration)";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("compId", compId);
    params.source.addValue("userId", userId);
    params.source.addValue("serviceTag", serviceTag);
    params.source.addValue("make", make);
    params.source.addValue("model", model);
    params.source.addValue("expiration", expiration);
    return params;
  }

  class SqlParams{
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();  
    }
  
  private SqlParams generateUpdateSql(Date expiration, Long compId, Long userId, String serviceTag, String make, String model) {
    log.info("DAO: expiration={}, compId={}, userId={}, serviceTag={}, make={}, model={}", expiration, compId, userId, serviceTag, make, model);
    String sql = ""
        + "Update Computers "
        + "Set userId = :userId, serviceTag = :serviceTag, make = :make, model = :model, expiration = :expiration "
        + "Where compId = :compId";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("serviceTag", serviceTag);
    params.source.addValue("make", make);
    params.source.addValue("model", model);
    params.source.addValue("expiration", expiration);
    Map<String, Object> params2 = new HashMap<>();
    params2.put("compId", compId);
    params2.put("userId", userId);
    params.source.addValues(params2);
    return params;
  }  
  
  @Override
  public Optional<Computers> deleteComputers(Long compId){
    SqlParams params = generateDeleteSql(compId);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Computers.builder()
        .compId(compId)
        .build());    
  }

  private SqlParams generateDeleteSql(Long compId) {
      String sql = ""
          + "DELETE FROM Computers "
          + "Where compId = :compId";
      SqlParams params = new SqlParams();
      params.sql = sql;
      Map<String, Object> params2 = new HashMap<>();
      params2.put("compId", compId);
      params.source.addValues(params2);
      return params;
  }
}

