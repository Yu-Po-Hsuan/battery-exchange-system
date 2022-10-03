package com.yupohsuan.batteryexchangesystem.service;

import com.yupohsuan.batteryexchangesystem.dto.BatteryRequest;
import com.yupohsuan.batteryexchangesystem.model.Battery;

public interface BatteryService {
    Battery getBatteryById(Integer batteryId);

    Integer createBattery(BatteryRequest batteryRequest);

    void updateBattery(Integer batteryId, BatteryRequest batteryRequest);

    void deleteBattery(Integer batteryId);
}
