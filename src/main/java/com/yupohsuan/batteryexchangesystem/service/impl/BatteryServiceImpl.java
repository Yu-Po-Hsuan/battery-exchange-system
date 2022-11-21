package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.BatteryDao;
import com.yupohsuan.batteryexchangesystem.dao.MemberDao;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.service.BatteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatteryServiceImpl implements BatteryService {

    private final static Logger log = LoggerFactory.getLogger(BatteryServiceImpl.class);

    @Autowired
    private BatteryDao batteryDao;

    @Autowired
    private MemberDao memberDao;


    @Override
    public Battery getBatteryById(Integer batteryId) {
        return batteryDao.getBatteryById(batteryId);
    }

    @Override
    public Integer createBattery(Integer batteryLevel) {
        return batteryDao.createBattery(batteryLevel);
    }

    @Override
    public void updateBattery(Integer batteryId,Integer batteryLevel) {

        batteryDao.updateBattery(batteryId, batteryLevel);
    }


    @Override
    public void deleteBattery(Integer batteryId) {
        batteryDao.deleteBattery(batteryId);
    }
}
