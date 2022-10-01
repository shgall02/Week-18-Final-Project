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
import com.promineotech.inventory.entity.RequestType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRequestTypeDao implements RequestTypeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 
  
  public Optional<RequestType> fetchRequestType(Long typeId) {
    log.info("DAO: typeId={}", typeId);
    
    String sql = ""
        +"Select * "
        +"FROM RequestType "
        +"WHERE typeId = :typeId";
    
    Map<String, Object> params = new HashMap<>();
    params.put("typeId", typeId);
    return Optional.ofNullable( 
        jdbcTemplate.query(sql, params, new RequestTypeResultSetExtractor()));
  }
      class RequestTypeResultSetExtractor implements ResultSetExtractor<RequestType> {

    
    @Override
    public RequestType extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      return RequestType.builder()
          .typeId(rs.getLong("typeId"))
          .typeName(rs.getString("typeName"))
          .build();
    }     
    
  }
  
  public Optional<RequestType> createRequestType(Long typeId, String typeName) {
    log.info("DAO: typeId={}, typeName={}", typeId, typeName);
    SqlParams params = generateInsertSql(typeId, typeName);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    return Optional.of(RequestType.builder()
        .typeId(typeId)
        .typeName(typeName)
        .build());
  }
  
  private SqlParams generateInsertSql(Long typeId, String typeName)  {
    log.info("DAO: typeId={}, typeName={}", typeId, typeName);
    String sql = ""
        + "Insert into RequestType(typeId, typeName) "
        + "Values (:typeId, :typeName)";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("typeId", typeId);
    params.source.addValue("typeName", typeName);
    return params;
  }
  
  
  @Transactional
  public Optional<RequestType> updateRequestType(Long typeId, String typeName){
    log.info("DAO: typeId={}, typeName={}", typeId, typeName);
    SqlParams params = generateUpdateSql(typeId, typeName);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(RequestType.builder()
        .typeId(typeId)
        .typeName(typeName)
        .build());
  }

  class SqlParams{
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();  
    }
  
  private SqlParams generateUpdateSql(Long typeId, String typeName) {
    log.info("DAO: typeId={}, typeName={}", typeId, typeName);
    String sql = ""
        + "Update RequestType "
        + "Set typeName = :typeName "
        + "Where typeId = :typeId";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("typeName", typeName);
    Map<String, Object> params2 = new HashMap<>();
    params2.put("typeId", typeId);
    params.source.addValues(params2);
    return params;
  }  
  
  @Override
  public Optional<RequestType> deleteRequestType(Long typeId){
    SqlParams params = generateDeleteSql(typeId);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(RequestType.builder()
        .typeId(typeId)
        .build());    
  }

  private SqlParams generateDeleteSql(Long typeId) {
      String sql = ""
          + "DELETE FROM RequestType "
          + "Where typeId = :typeId";
      SqlParams params = new SqlParams();
      params.sql = sql;
      Map<String, Object> params2 = new HashMap<>();
      params2.put("typeId", typeId);
      params.source.addValues(params2);
      return params;
  }
}

