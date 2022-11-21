package com.yupohsuan.batteryexchangesystem.rowmapper;

import com.yupohsuan.batteryexchangesystem.model.Battery;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BatteryRowMapper implements RowMapper<Battery> {
    @Override
    public Battery mapRow(ResultSet resultSet, int i) throws SQLException {
        Battery battery = new Battery();
        battery.setBatteryId(resultSet.getInt("battery_id"));
        battery.setBatteyLevel(resultSet.getInt("battery_level"));
        battery.setCreatedDate(resultSet.getTimestamp("created_date"));
        battery.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return battery;

    }
}
