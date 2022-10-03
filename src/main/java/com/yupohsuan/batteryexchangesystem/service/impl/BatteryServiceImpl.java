package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.BatteryDao;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    private BatteryDao batteryDao;

    @Override
    public Battery getBatteryById(Integer batteryId) {
        return batteryDao.getBatteryById(batteryId);
    }
}
