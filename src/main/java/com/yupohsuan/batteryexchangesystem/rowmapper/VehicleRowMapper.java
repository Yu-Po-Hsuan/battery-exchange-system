package com.yupohsuan.batteryexchangesystem.rowmapper;

import com.yupohsuan.batteryexchangesystem.model.Vehicle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleRowMapper implements RowMapper<Vehicle> {

    @Override
    public Vehicle mapRow(ResultSet resultSet, int i) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(resultSet.getInt("vehicle_id"));
        vehicle.setLicensePlateNumber(resultSet.getString("license_plate_number"));
        vehicle.setLatitude(resultSet.getDouble("latitude"));
        vehicle.setLongitude(resultSet.getDouble("longitude"));
        vehicle.setBatteryLevel(resultSet.getInt("battery_level"));
        vehicle.setMemberId(resultSet.getInt("member_id"));
        vehicle.setCreatedDate(resultSet.getTimestamp("created_date"));
        vehicle.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        return vehicle;
    }
}
