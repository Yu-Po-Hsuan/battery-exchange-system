package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.BatteryDao;
import com.yupohsuan.batteryexchangesystem.dao.MemberDao;
import com.yupohsuan.batteryexchangesystem.dto.BatteryRequest;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.model.Member;
import com.yupohsuan.batteryexchangesystem.service.BatteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class BatteryServiceImpl implements BatteryService {

    private final static Logger log = LoggerFactory.getLogger(BatteryServiceImpl.class);

    @Autowired
    private BatteryDao batteryDao;

    @Autowired
    private MemberDao memberDao;

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
        Member member = memberDao.getMemberById(batteryRequest.getMemberId());

        if (member == null) {
            log.warn("member_id 為 {} 的帳號不存在", batteryRequest.getMemberId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return batteryDao.createBattery(batteryRequest);
    }

    @Override
    public void updateBattery(Integer batteryId,BatteryRequest batteryRequest) {
        Member member = memberDao.getMemberById(batteryRequest.getMemberId());

        if (member == null) {
            log.warn("member_id 為 {} 的帳號不存在", batteryRequest.getMemberId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        batteryDao.updateBattery(batteryId, batteryRequest);
    }

    @Override
    public void updateBatteryHolder(Integer batteryId, Integer memberId) {

        Member member = memberDao.getMemberById(memberId);

        if (member == null) {
            log.warn("member_id 為 {} 的帳號不存在", memberId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        batteryDao.updateBatteryHolder(batteryId, memberId);
    }

    @Override
    public void deleteBattery(Integer batteryId) {
        batteryDao.deleteBattery(batteryId);
    }
}
