package com.yupohsuan.batteryexchangesystem.dao.impl;

import com.yupohsuan.batteryexchangesystem.dao.BatteryDao;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.rowmapper.BatteryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BatteryDaoImpl implements BatteryDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Battery getBatteryById(Integer batteryId) {
        String sql = "SELECT battery_id, longitude, latitude, battery_level, member_id, created_date, last_modified_date " +
                "FROM battery WHERE battery_id = :batteryId";

        Map<String, Object> map = new HashMap<>();
        map.put("batteryId", batteryId);

        List<Battery> batteryList = namedParameterJdbcTemplate.query(sql, map, new BatteryRowMapper());

        if (batteryList.size() > 0) {
            return batteryList.get(0);
        }else {
            return null;
        }

    }
}
