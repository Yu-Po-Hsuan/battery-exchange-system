package com.yupohsuan.batteryexchangesystem.dao;

import com.yupohsuan.batteryexchangesystem.dto.BatteryRequest;
import com.yupohsuan.batteryexchangesystem.model.Battery;

import java.util.List;

public interface BatteryDao {
    Integer countBatteries(Integer batteryLevel);

    List<Battery> getBatteries(Integer batteryLevel);

    Battery getBatteryById(Integer batteryId);

    Integer createBattery(BatteryRequest batteryRequest);

    void updateBattery(Integer batteryId, BatteryRequest batteryRequest);

    void updateBatteryHolder(Integer batteryId, Integer memberId);

    void deleteBattery(Integer batteryId);
}
