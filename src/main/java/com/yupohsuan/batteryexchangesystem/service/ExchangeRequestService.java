package com.yupohsuan.batteryexchangesystem.service;

import com.yupohsuan.batteryexchangesystem.dto.ExchangeRequestCreateRequest;
import com.yupohsuan.batteryexchangesystem.model.ExchangeRequest;

import java.util.List;

public interface ExchangeRequestService {
    ExchangeRequest getExchangeRequestBySendersPhone(String sendersPhone);

    ExchangeRequest getExchangeRequestByReceiversPhone(String receiversPhone);

    Integer createExchangeRequest(ExchangeRequestCreateRequest exchangeRequestCreateRequest);

    ExchangeRequest getExchangeRequestById(Integer exchangeRequestId);

    void updateStatus(ExchangeRequestCreateRequest statusChange);

    void deleteRequest(Integer requestId);
}
