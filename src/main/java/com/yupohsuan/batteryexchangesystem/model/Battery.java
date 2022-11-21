package com.yupohsuan.batteryexchangesystem.model;

import java.util.Date;

public class Battery {
    private Integer batteryId;
    private Integer batteyLevel;
    private Date createdDate;
    private Date lastModifiedDate;

    public Integer getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(Integer batteryId) {
        this.batteryId = batteryId;
    }

    public Integer getBatteyLevel() {
        return batteyLevel;
    }

    public void setBatteyLevel(Integer batteyLevel) {
        this.batteyLevel = batteyLevel;
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
