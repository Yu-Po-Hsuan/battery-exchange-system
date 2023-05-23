package com.yupohsuan.batteryexchangesystem.dao;

import com.yupohsuan.batteryexchangesystem.dto.VehicleCreateRequest;
import com.yupohsuan.batteryexchangesystem.dto.VehicleDataRequest;
import com.yupohsuan.batteryexchangesystem.model.Vehicle;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;

import java.util.List;

public interface VehicleDao {
    List<VehiclesResponse> getVehicles();
//    void updateBatteryId(Integer vehicleId, Integer batteryId);
//    Integer getBatteryIdByVehicleId(Integer vehicleId);

    Vehicle getVehicleById(Integer vehicleId);

    Integer createVehicle(VehicleCreateRequest vehicleCreateRequest);

    void updateVehicleData(VehicleDataRequest vehicleDataRequest);
}
