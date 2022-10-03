package com.yupohsuan.batteryexchangesystem.model;

import java.util.Date;

public class Battery {
    private Integer batteryId;
    private String longitude;
    private String latitude;
    private Integer batteyLevel;
    private Integer memberId;
    private Date createdDate;
    private Date lastModifiedDate;

    public Integer getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(Integer batteryId) {
        this.batteryId = batteryId;
    }

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

    public Integer getBatteyLevel() {
        return batteyLevel;
    }

    public void setBatteyLevel(Integer batteyLevel) {
        this.batteyLevel = batteyLevel;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
