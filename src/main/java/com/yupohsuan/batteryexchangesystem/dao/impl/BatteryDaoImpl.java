package com.yupohsuan.batteryexchangesystem.dao.impl;

import com.yupohsuan.batteryexchangesystem.dao.BatteryDao;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.rowmapper.BatteryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BatteryDaoImpl implements BatteryDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Battery getBatteryById(Integer batteryId) {
        String sql = "SELECT battery_id, battery_level, created_date, last_modified_date " +
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

    @Override
    public Integer createBattery(Integer batteryLevel) {
        String sql = "INSERT INTO battery (battery_level, created_date, last_modified_date) " +
                "VALUES (:batteryLevel,:createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("batteryLevel", batteryLevel);

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        Integer BatteryId = keyHolder.getKey().intValue();

        return BatteryId;
    }

    @Override
    public void updateBattery(Integer batteryId, Integer batteryLevel) {
        String sql = "UPDATE battery SET battery_level = :batteryLevel, " +
                "last_modified_date = :lastModifiedDate WHERE battery_id = :batteryId";

        Map<String, Object> map = new HashMap<>();
        map.put("batteryId",batteryId);


        map.put("batteryLevel",batteryLevel);

        map.put("lastModifiedDate",new Date());

        namedParameterJdbcTemplate.update(sql,map);
    }



    @Override
    public void deleteBattery(Integer batteryId) {
        String sql = "DELETE FROM battery WHERE battery_id = :batteryId";

        Map<String, Object> map = new HashMap<>();
        map.put("batteryId", batteryId);

        namedParameterJdbcTemplate.update(sql,map);
    }
}
