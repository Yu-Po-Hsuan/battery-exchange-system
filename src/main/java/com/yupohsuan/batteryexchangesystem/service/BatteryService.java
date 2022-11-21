package com.yupohsuan.batteryexchangesystem.service;

import com.yupohsuan.batteryexchangesystem.model.Battery;

public interface BatteryService {

    Battery getBatteryById(Integer batteryId);

    Integer createBattery(Integer batteryLevel);

    void updateBattery(Integer batteryId, Integer batteryLevel);

    void deleteBattery(Integer batteryId);
}
