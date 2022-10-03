package com.yupohsuan.batteryexchangesystem.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class BatteryRequest {

    @NotNull
    private String longitude;

    @NotNull
    private String latitude;

    @NotNull
    @JsonProperty("battery_level")
    private Integer batteryLevel;

    @NotNull
    @JsonProperty("member_id")
    private Integer memberId;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
