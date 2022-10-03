package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.BatteryDao;
import com.yupohsuan.batteryexchangesystem.dto.BatteryRequest;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    private BatteryDao batteryDao;

    @Override
    public Integer countBatteries(Integer batteryLevel) {
        return batteryDao.countBatteries(batteryLevel);
    }

    @Override
    public List<Battery> getBatteries(Integer batteryLevel) {
        return batteryDao.getBatteries(batteryLevel);
    }

    @Override
    public Battery getBatteryById(Integer batteryId) {
        return batteryDao.getBatteryById(batteryId);
    }

    @Override
    public Integer createBattery(BatteryRequest batteryRequest) {
        return batteryDao.createBattery(batteryRequest);
    }

    @Override
    public void updateBattery(Integer batteryId,BatteryRequest batteryRequest) {
        batteryDao.updateBattery(batteryId, batteryRequest);
    }

    @Override
    public void deleteBattery(Integer batteryId) {
        batteryDao.deleteBattery(batteryId);
    }
}
