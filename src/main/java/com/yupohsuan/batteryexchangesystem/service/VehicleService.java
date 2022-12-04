package com.yupohsuan.batteryexchangesystem.service;

import com.yupohsuan.batteryexchangesystem.dto.VehicleLocationRequest;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;

import java.util.List;

public interface VehicleService {
    List<VehiclesResponse> getVehicles();

    Integer getBatteryId(Integer vehicleId);

    void exchange(Integer MyVehicleId, Integer TargetVehicleId);

    void updateLocation(VehicleLocationRequest vehicleLocationRequest);
}
