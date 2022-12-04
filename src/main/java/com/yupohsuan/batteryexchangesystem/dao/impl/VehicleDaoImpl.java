package com.yupohsuan.batteryexchangesystem.dao.impl;

import com.yupohsuan.batteryexchangesystem.dao.VehicleDao;
import com.yupohsuan.batteryexchangesystem.dto.VehicleLocationRequest;
import com.yupohsuan.batteryexchangesystem.rowmapper.VehiclesResponseRowMapper;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<VehiclesResponse> getVehicles() {

        String sql = "SELECT v.vehicle_id, v.latitude, v.longitude, b.battery_level, m.phone_number " +
                "FROM vehicle as v LEFT JOIN battery as b ON v.battery_id = b.battery_id " +
                "LEFT JOIN member as m ON v.member_id = m.member_id;";

        Map<String, Object> map = new HashMap<>();

        List<VehiclesResponse> vehiclesResponseList = namedParameterJdbcTemplate.query(sql,map,new VehiclesResponseRowMapper());

        return vehiclesResponseList;
    }

    @Override
    public Integer getBatteryIdByVehicleId(Integer vehicleId) {

        String sql = "SELECT battery_id FROM vehicle WHERE vehicle_id = :vehicleId;";

        Map<String, Object> map = new HashMap<>();
        map.put("vehicleId", vehicleId);

        return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
    }

    @Override
    public void updateBatteryId(Integer vehicleId, Integer batteryId) {

        String sql = "UPDATE vehicle SET battery_id = :batteryId WHERE vehicle_id = :vehicleId;";

        Map<String, Object> map = new HashMap<>();
        map.put("batteryId", batteryId);
        map.put("vehicleId", vehicleId);

        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public void updateLocation(VehicleLocationRequest vehicleLocationRequest) {
        String sql = "UPDATE vehicle SET latitude = :latitude, longitude = :longitude," +
                " last_modified_date = :lastModifiedDate WHERE vehicle_id = :vehicleId;";

        Map<String, Object> map = new HashMap<>();
        map.put("latitude", vehicleLocationRequest.getLatitude());
        map.put("longitude", vehicleLocationRequest.getLongitude());
        map.put("vehicleId", vehicleLocationRequest.getVehicleId());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }
}
