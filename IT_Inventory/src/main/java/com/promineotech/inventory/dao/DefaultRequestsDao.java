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
import com.promineotech.inventory.entity.Requests;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRequestsDao implements RequestsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 
  
  public Optional<Requests> fetchRequests(Long requestId) {
    log.info("DAO: requestId={}", requestId);
    
    String sql = ""
        +"Select * "
        +"FROM Requests "
        +"WHERE requestId = :requestId";
    
    Map<String, Object> params = new HashMap<>();
    params.put("requestId", requestId);
    return Optional.ofNullable( 
        jdbcTemplate.query(sql, params, new RequestsResultSetExtractor()));
  }
      class RequestsResultSetExtractor implements ResultSetExtractor<Requests> {

    
    @Override
    public Requests extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      return Requests.builder()
          .requestId(rs.getLong("requestId"))
          .userId(rs.getLong("userId"))
          .typeId(rs.getLong("typeId"))
          .quantity(rs.getInt("quantity"))
          .shipDate(rs.getDate("shipDate"))
          .receiveDate(rs.getDate("receiveDate"))
          .returnDate(rs.getDate("returnDate"))
          .build();
    }     
    
  }
  
  public Optional<Requests> createRequests(Date shipDate, Date receiveDate, Date returnDate, Long requestId, Long userId, Long typeId, int quantity) {
    log.info("DAO: shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
    SqlParams params = generateInsertSql(shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    return Optional.of(Requests.builder()
        .shipDate(shipDate)
        .receiveDate(receiveDate)
        .returnDate(returnDate)
        .requestId(requestId)
        .userId(userId)
        .typeId(typeId)
        .quantity(quantity)
        .build());
  }
  @Transactional
  public Optional<Requests> updateRequests(Date shipDate, Date receiveDate, Date returnDate, Long requestId, Long userId, Long typeId, int quantity){
    log.info("DAO: shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
    SqlParams params = generateUpdateSql(shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Requests.builder()
        .shipDate(shipDate)
        .receiveDate(receiveDate)
        .returnDate(returnDate)
        .requestId(requestId)
        .userId(userId)
        .typeId(typeId)
        .quantity(quantity)
        .build());
  }

  private SqlParams generateInsertSql(Date shipDate, Date receiveDate, Date returnDate, Long requestId, Long userId, Long typeId, int quantity)  {
    log.info("DAO: shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
    String sql = ""
        + "Insert into Requests(shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity) "
        + "Values (:shipDate, :receiveDate, :returnDate, :requestId, :userId, :typeId, :quantity)";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("shipDate", shipDate);
    params.source.addValue("receiveDate", receiveDate);
    params.source.addValue("returnDate", returnDate);
    params.source.addValue("requestId", requestId);
    params.source.addValue("userId", userId);
    params.source.addValue("typeId", typeId);
    params.source.addValue("quantity", quantity);
    return params;
  }

  class SqlParams{
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();  
    }
  
  private SqlParams generateUpdateSql(Date shipDate, Date receiveDate, Date returnDate, Long requestId, Long userId, Long typeId, int quantity) {
    log.info("DAO: shipDate={}, receiveDate={}, returnDate={}, requestId={}, userId={}, typeId={}, quantity={}", shipDate, receiveDate, returnDate, requestId, userId, typeId, quantity);
    String sql = ""
        + "Update Requests "
        + "Set shipDate = :shipDate, receiveDate = :receiveDate, returnDate = :returnDate, userId = :userId, typeId = :typeId, quantity = :quantity "
        + "Where requestId = :requestId";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("shipDate", shipDate);
    params.source.addValue("receiveDate", receiveDate);
    params.source.addValue("returnDate", returnDate);
    params.source.addValue("requestId", requestId);
    params.source.addValue("quantity", quantity);
    Map<String, Object> params2 = new HashMap<>();
    params2.put("requestId", requestId);
    params2.put("userId", userId);
    params2.put("typeId", typeId);
    params.source.addValues(params2);
    return params;
  }  
  
  @Override
  public Optional<Requests> deleteRequests(Long requestId){
    SqlParams params = generateDeleteSql(requestId);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Requests.builder()
        .requestId(requestId)
        .build());    
  }

  private SqlParams generateDeleteSql(Long requestId) {
      String sql = ""
          + "DELETE FROM Requests "
          + "Where requestId = :requestId";
      SqlParams params = new SqlParams();
      params.sql = sql;
      Map<String, Object> params2 = new HashMap<>();
      params2.put("requestId", requestId);
      params.source.addValues(params2);
      return params;
  }
}

