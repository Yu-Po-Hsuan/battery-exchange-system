package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.VehicleDao;
import com.yupohsuan.batteryexchangesystem.service.VehicleService;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public List<VehiclesResponse> getVehicles() {
        return vehicleDao.getVehicles();
    }


    @Override
    public Integer getBatteryId(Integer vehicleId) {
        return vehicleDao.getBatteryIdByVehicleId(vehicleId);
    }

    @Override
    @Transactional
    public void exchange(Integer MyVehicleId, Integer TargetVehicleId) {
            Integer MyBatteryId = vehicleDao.getBatteryIdByVehicleId(MyVehicleId);
            Integer TargetBatteryId = vehicleDao.getBatteryIdByVehicleId(TargetVehicleId);

            vehicleDao.updateBatteryId(TargetVehicleId, MyBatteryId);
            vehicleDao.updateBatteryId(MyVehicleId, TargetBatteryId);
    }
}
