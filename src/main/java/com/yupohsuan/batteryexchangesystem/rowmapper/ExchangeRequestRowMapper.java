package com.yupohsuan.batteryexchangesystem.rowmapper;

import com.yupohsuan.batteryexchangesystem.dao.ExchangeRequestDao;
import com.yupohsuan.batteryexchangesystem.model.ExchangeRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangeRequestRowMapper implements RowMapper<ExchangeRequest> {
    @Override
    public ExchangeRequest mapRow(ResultSet resultSet, int i) throws SQLException {
        ExchangeRequest exchangeRequest = new ExchangeRequest();
        exchangeRequest.setExchangeRequestId(resultSet.getInt("exchange_request_id"));
        exchangeRequest.setSendersPhone(resultSet.getString("senders_phone"));
        exchangeRequest.setReceiversPhone(resultSet.getString("receivers_phone"));
        exchangeRequest.setStatus(resultSet.getString("status"));
        exchangeRequest.setCreatedDate(resultSet.getTimestamp("created_date"));
        exchangeRequest.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        return exchangeRequest;
    }
}
