package com.yupohsuan.batteryexchangesystem.dao.impl;

import com.yupohsuan.batteryexchangesystem.dao.BatteryDao;
import com.yupohsuan.batteryexchangesystem.dto.BatteryRequest;
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
    public Integer countBatteries(Integer batteryLevel) {
        String sql = "SELECT count(*) FROM battery WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        if (batteryLevel != null) {
            sql = sql + " AND battery_level >= :batteryLevel";
            map.put("batteryLevel",batteryLevel);
        }

        return namedParameterJdbcTemplate.queryForObject(sql,map,Integer.class);
    }

    @Override
    public List<Battery> getBatteries(Integer batteryLevel) {
        String sql = "SELECT battery_id, longitude, latitude, battery_level, member_id, created_date, last_modified_date " +
                "FROM battery WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        if (batteryLevel != null) {
            sql = sql + " AND battery_level >= :batteryLevel";
            map.put("batteryLevel",batteryLevel);
        }

        List<Battery> batteryList = namedParameterJdbcTemplate.query(sql, map, new BatteryRowMapper());

        if (batteryList.size() > 0) {
            return batteryList;
        }else {
            return null;
        }
    }

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

    @Override
    public Integer createBattery(BatteryRequest batteryRequest) {
        String sql = "INSERT INTO battery (longitude, latitude, battery_level, member_id, created_date, last_modified_date) " +
                "VALUES (:longitude, :latitude, :batteryLevel, :memberId, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("longitude", batteryRequest.getLongitude());
        map.put("latitude", batteryRequest.getLatitude());
        map.put("batteryLevel", batteryRequest.getBatteryLevel());
        map.put("memberId",batteryRequest.getMemberId());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        Integer BatteryId = keyHolder.getKey().intValue();

        return BatteryId;
    }

    @Override
    public void updateBattery(Integer batteryId, BatteryRequest batteryRequest) {
        String sql = "UPDATE battery SET longitude = :longitude, latitude = :latitude, battery_level = :batteryLevel, member_id = :memberId, " +
                "last_modified_date = :lastModifiedDate WHERE battery_id = :batteryId";

        Map<String, Object> map = new HashMap<>();
        map.put("batteryId",batteryId);

        map.put("longitude", batteryRequest.getLongitude());
        map.put("latitude",batteryRequest.getLatitude());
        map.put("batteryLevel",batteryRequest.getBatteryLevel());
        map.put("memberId",batteryRequest.getMemberId());

        map.put("lastModifiedDate",new Date());

        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public void updateBatteryHolder(Integer batteryId, Integer memberId) {
        String sql = "UPDATE battery SET member_id = :memberId, last_modified_date = :lastModifiedDate " +
                "WHERE battery_id = :batteryId";

        Map<String, Object> map = new HashMap<>();
        map.put("batteryId",batteryId);
        map.put("memberId",memberId);

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
