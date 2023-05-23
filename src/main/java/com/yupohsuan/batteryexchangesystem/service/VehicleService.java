package com.yupohsuan.batteryexchangesystem.service;

import com.yupohsuan.batteryexchangesystem.dto.VehicleCreateRequest;
import com.yupohsuan.batteryexchangesystem.dto.VehicleDataRequest;
import com.yupohsuan.batteryexchangesystem.model.Vehicle;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;

import java.util.List;

public interface VehicleService {
    List<VehiclesResponse> getVehicles();

//    Integer getBatteryId(Integer vehicleId);
//
//    void exchange(Integer MyVehicleId, Integer TargetVehicleId);

    Vehicle getVehicleById(Integer vehicleId);

    Integer createVehicle(VehicleCreateRequest vehicleCreateRequest);

    void updateVehicleData(VehicleDataRequest vehicleDataRequest);
}
