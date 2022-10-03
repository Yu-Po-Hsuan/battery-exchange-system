package com.yupohsuan.batteryexchangesystem.dao;

import com.yupohsuan.batteryexchangesystem.model.Battery;

public interface BatteryDao {
    Battery getBatteryById(Integer batteryId);
}
