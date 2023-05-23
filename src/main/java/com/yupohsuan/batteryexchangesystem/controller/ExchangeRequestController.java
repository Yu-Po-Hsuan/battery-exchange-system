package com.yupohsuan.batteryexchangesystem.controller;

import com.yupohsuan.batteryexchangesystem.dto.ExchangeRequestCreateRequest;
import com.yupohsuan.batteryexchangesystem.model.ExchangeRequest;
import com.yupohsuan.batteryexchangesystem.service.ExchangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ExchangeRequestController {

    @Autowired
    private ExchangeRequestService exchangeRequestService;

    @GetMapping("/exchange-requests/s")
    public ResponseEntity<ExchangeRequest> getExchangeRequestBySendersPhone(@RequestParam String sendersPhone) {
        ExchangeRequest exchangeRequest = exchangeRequestService.getExchangeRequestBySendersPhone(sendersPhone);

        return ResponseEntity.status(HttpStatus.OK).body(exchangeRequest);
    }

    @GetMapping("/exchange-requests/r")
    public ResponseEntity<ExchangeRequest> getExchangeRequestByReceiversPhone(@RequestParam String receiversPhone) {
        ExchangeRequest exchangeRequest = exchangeRequestService.getExchangeRequestByReceiversPhone(receiversPhone);

        return ResponseEntity.status(HttpStatus.OK).body(exchangeRequest);
    }

    @PostMapping("/exchange-requests")
    public ResponseEntity<ExchangeRequest> createExchangeRequest(@RequestBody ExchangeRequestCreateRequest exchangeRequestCreateRequest) {
        Integer exchangeRequestId = exchangeRequestService.createExchangeRequest(exchangeRequestCreateRequest);

        ExchangeRequest exchangeRequest = exchangeRequestService.getExchangeRequestById(exchangeRequestId);

        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeRequest);
    }

    @PutMapping("/exchange-requests")
    public ResponseEntity<?> updateStatus(@RequestBody ExchangeRequestCreateRequest statusChange) {
        exchangeRequestService.updateStatus(statusChange);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/exchange-requests/{requestId}")
    public ResponseEntity<?> deleteRequest(@PathVariable Integer requestId) {
        exchangeRequestService.deleteRequest(requestId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
