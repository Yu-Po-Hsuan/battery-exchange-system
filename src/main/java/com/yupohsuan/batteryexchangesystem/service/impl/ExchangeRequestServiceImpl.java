package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.ExchangeRequestDao;
import com.yupohsuan.batteryexchangesystem.dto.ExchangeRequestCreateRequest;
import com.yupohsuan.batteryexchangesystem.model.ExchangeRequest;
import com.yupohsuan.batteryexchangesystem.service.ExchangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeRequestServiceImpl implements ExchangeRequestService {

    @Autowired
    private ExchangeRequestDao exchangeRequestDao;

    @Override
    public ExchangeRequest getExchangeRequestBySendersPhone(String sendersPhone) {
        return exchangeRequestDao.getExchangeRequestBySendersPhone(sendersPhone);
    }

    @Override
    public ExchangeRequest getExchangeRequestByReceiversPhone(String receiversPhone) {
        return exchangeRequestDao.getExchangeRequestByReceiversPhone(receiversPhone);
    }

    @Override
    public Integer createExchangeRequest(ExchangeRequestCreateRequest exchangeRequestCreateRequest) {
        return exchangeRequestDao.createExchangeRequest(exchangeRequestCreateRequest);
    }

    @Override
    public ExchangeRequest getExchangeRequestById(Integer exchangeRequestId) {
        return exchangeRequestDao.getExchangeRequestById(exchangeRequestId);
    }

    @Override
    public void updateStatus(ExchangeRequestCreateRequest statusChange) {
        exchangeRequestDao.updateStatus(statusChange);
    }

    @Override
    public void deleteRequest(Integer requestId) {
        exchangeRequestDao.deleteRequest(requestId);
    }
}
