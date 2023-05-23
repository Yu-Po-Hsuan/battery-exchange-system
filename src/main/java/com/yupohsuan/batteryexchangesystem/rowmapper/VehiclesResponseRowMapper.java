package com.yupohsuan.batteryexchangesystem.rowmapper;

import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiclesResponseRowMapper implements RowMapper<VehiclesResponse> {
    @Override
    public VehiclesResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        VehiclesResponse vehiclesResponse = new VehiclesResponse();
        vehiclesResponse.setVehicleId(resultSet.getInt("vehicle_id"));
        vehiclesResponse.setLicensePlateNumber(resultSet.getString("license_plate_number"));
        vehiclesResponse.setLatitude(resultSet.getDouble("latitude"));
        vehiclesResponse.setLongitude(resultSet.getDouble("longitude"));
        vehiclesResponse.setBatteryLevel(resultSet.getInt("battery_level"));
        vehiclesResponse.setPhoneNumber(resultSet.getString("phone_number"));
        return vehiclesResponse;
    }
}
