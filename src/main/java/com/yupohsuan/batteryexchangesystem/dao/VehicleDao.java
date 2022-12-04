package com.yupohsuan.batteryexchangesystem.dao;

import com.yupohsuan.batteryexchangesystem.dto.VehicleLocationRequest;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;

import java.util.List;

public interface VehicleDao {
    List<VehiclesResponse> getVehicles();
    void updateBatteryId(Integer vehicleId, Integer batteryId);
    Integer getBatteryIdByVehicleId(Integer vehicleId);
    void updateLocation(VehicleLocationRequest vehicleLocationRequest);
}
