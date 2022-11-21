package com.yupohsuan.batteryexchangesystem.dao;

import com.yupohsuan.batteryexchangesystem.model.Battery;

public interface BatteryDao {

    Battery getBatteryById(Integer batteryId);

    Integer createBattery(Integer batteryLevel);

    void updateBattery(Integer batteryId, Integer batteryLevel);

    void deleteBattery(Integer batteryId);
}
