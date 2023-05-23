package com.yupohsuan.batteryexchangesystem.dao.impl;

import com.yupohsuan.batteryexchangesystem.dao.ExchangeRequestDao;
import com.yupohsuan.batteryexchangesystem.dto.ExchangeRequestCreateRequest;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.model.ExchangeRequest;
import com.yupohsuan.batteryexchangesystem.rowmapper.BatteryRowMapper;
import com.yupohsuan.batteryexchangesystem.rowmapper.ExchangeRequestRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExchangeRequestDaoImpl implements ExchangeRequestDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ExchangeRequest getExchangeRequestBySendersPhone(String sendersPhone) {
        String sql = "SELECT exchange_request_id, senders_phone, receivers_phone, status, created_date, last_modified_date " +
                "FROM exchange_requests WHERE senders_phone = :sendersPhone";

        Map<String, Object> map = new HashMap<>();
        map.put("sendersPhone", sendersPhone);

        List<ExchangeRequest> exchangeRequestList = namedParameterJdbcTemplate.query(sql, map, new ExchangeRequestRowMapper());

        if (exchangeRequestList.size() > 0) {
            return exchangeRequestList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public ExchangeRequest getExchangeRequestByReceiversPhone(String receiversPhone) {
        String sql = "SELECT exchange_request_id, senders_phone, receivers_phone, status, created_date, last_modified_date " +
                "FROM exchange_requests WHERE receivers_phone = :receiversPhone";

        Map<String, Object> map = new HashMap<>();
        map.put("receiversPhone", receiversPhone);

        List<ExchangeRequest> exchangeRequestList = namedParameterJdbcTemplate.query(sql, map, new ExchangeRequestRowMapper());

        if (exchangeRequestList.size() > 0) {
            return exchangeRequestList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Integer createExchangeRequest(ExchangeRequestCreateRequest exchangeRequestCreateRequest) {
        String sql = "INSERT INTO exchange_requests (senders_phone, receivers_phone, status, created_date, last_modified_date) " +
                "VALUES (:sendersPhone, :receiversPhone, :status, :createdDate, :lastModifiedDate);";

        Map<String, Object> map = new HashMap<>();
        map.put("sendersPhone", exchangeRequestCreateRequest.getSendersPhone());
        map.put("receiversPhone", exchangeRequestCreateRequest.getReceiversPhone());
        map.put("status", exchangeRequestCreateRequest.getStatus());

        map.put("createdDate", new Date());
        map.put("lastModifiedDate", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        Integer exchangeRequestId = keyHolder.getKey().intValue();

        return exchangeRequestId;
    }

    @Override
    public ExchangeRequest getExchangeRequestById(Integer exchangeRequestId) {
        String sql = "SELECT exchange_request_id, senders_phone, receivers_phone, status, created_date, last_modified_date " +
                "FROM exchange_requests WHERE exchange_request_id = :exchangeRequestId";

        Map<String, Object> map = new HashMap<>();
        map.put("exchangeRequestId", exchangeRequestId);

        List<ExchangeRequest> exchangeRequestList = namedParameterJdbcTemplate.query(sql, map, new ExchangeRequestRowMapper());

        if (exchangeRequestList.size() > 0) {
            return exchangeRequestList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void updateStatus(ExchangeRequestCreateRequest statusChange) {
        String sql = "UPDATE exchange_requests SET status = :status, last_modified_date = :lastModifiedDate " +
                "WHERE senders_phone = :sendersPhone AND receivers_phone = :receiversPhone;";

        Map<String, Object> map = new HashMap<>();
        map.put("status", statusChange.getStatus());
        map.put("sendersPhone", statusChange.getSendersPhone());
        map.put("receiversPhone", statusChange.getReceiversPhone());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteRequest(Integer requestId) {
        String sql = "DELETE FROM exchange_requests WHERE exchange_request_id = :requestId";

        Map<String, Object> map = new HashMap<>();
        map.put("requestId", requestId);

        namedParameterJdbcTemplate.update(sql,map);
    }
}
