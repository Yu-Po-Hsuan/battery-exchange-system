package com.yupohsuan.batteryexchangesystem.dao.impl;

import com.yupohsuan.batteryexchangesystem.dao.VehicleDao;
import com.yupohsuan.batteryexchangesystem.dto.VehicleCreateRequest;
import com.yupohsuan.batteryexchangesystem.dto.VehicleDataRequest;
import com.yupohsuan.batteryexchangesystem.model.Member;
import com.yupohsuan.batteryexchangesystem.model.Vehicle;
import com.yupohsuan.batteryexchangesystem.rowmapper.MemberRowMapper;
import com.yupohsuan.batteryexchangesystem.rowmapper.VehicleRowMapper;
import com.yupohsuan.batteryexchangesystem.rowmapper.VehiclesResponseRowMapper;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;
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
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<VehiclesResponse> getVehicles() {

        String sql = "SELECT v.vehicle_id, v.license_plate_number, v.latitude, v.longitude, v.battery_level, m.phone_number " +
                "FROM vehicle as v LEFT JOIN member as m ON v.member_id = m.member_id;";

        Map<String, Object> map = new HashMap<>();

        List<VehiclesResponse> vehiclesResponseList = namedParameterJdbcTemplate.query(sql,map,new VehiclesResponseRowMapper());

        return vehiclesResponseList;
    }

//    @Override
//    public Integer getBatteryIdByVehicleId(Integer vehicleId) {
//
//        String sql = "SELECT battery_id FROM vehicle WHERE vehicle_id = :vehicleId;";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("vehicleId", vehicleId);
//
//        return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
//    }
//
//    @Override
//    public void updateBatteryId(Integer vehicleId, Integer batteryId) {
//
//        String sql = "UPDATE vehicle SET battery_id = :batteryId WHERE vehicle_id = :vehicleId;";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("batteryId", batteryId);
//        map.put("vehicleId", vehicleId);
//
//        namedParameterJdbcTemplate.update(sql,map);
//    }


    @Override
    public Vehicle getVehicleById(Integer vehicleId) {
        String sql = "SELECT vehicle_id, license_plate_number, latitude, longitude, battery_level, member_id, created_date, last_modified_date FROM vehicle " +
                "WHERE vehicle_id = :vehicleId";

        Map<String, Object> map = new HashMap<>();
        map.put("vehicleId", vehicleId);

        List<Vehicle> vehicleList = namedParameterJdbcTemplate.query(sql, map, new VehicleRowMapper());

        if (vehicleList.size() > 0) {
            return vehicleList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createVehicle(VehicleCreateRequest vehicleCreateRequest) {
        String sql = "INSERT INTO vehicle (license_plate_number, latitude, longitude, battery_level, member_id, created_date, last_modified_date) " +
                "VALUES (:licensePlateNumber, :latitude, :longitude, :batteryLevel, :memberId, :createdDate, :lastModifiedDate);";

        Map<String, Object> map = new HashMap<>();
        map.put("licensePlateNumber", vehicleCreateRequest.getLicensePlateNumber());
        map.put("latitude", vehicleCreateRequest.getLatitude());
        map.put("longitude", vehicleCreateRequest.getLongitude());
        map.put("batteryLevel", vehicleCreateRequest.getBatteryLevel());
        map.put("memberId", vehicleCreateRequest.getMemberId());

        map.put("createdDate", new Date());
        map.put("lastModifiedDate", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        Integer vehicleId = keyHolder.getKey().intValue();

        return vehicleId;
    }

    @Override
    public void updateVehicleData(VehicleDataRequest vehicleDataRequest) {
        String sql = "UPDATE vehicle SET latitude = :latitude, longitude = :longitude, battery_level = :batteryLevel," +
                " last_modified_date = :lastModifiedDate WHERE license_plate_number = :licensePlateNumber;";

        Map<String, Object> map = new HashMap<>();
        map.put("latitude", vehicleDataRequest.getLatitude());
        map.put("longitude", vehicleDataRequest.getLongitude());
        map.put("batteryLevel", vehicleDataRequest.getBatteryLevel());
        map.put("licensePlateNumber", vehicleDataRequest.getLicensePlateNumber());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }
}
