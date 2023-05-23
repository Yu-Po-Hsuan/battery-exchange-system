package com.yupohsuan.batteryexchangesystem.model;

import java.util.Date;

public class ExchangeRequest {
    private Integer exchangeRequestId;
    private String sendersPhone;
    private String receiversPhone;
    private String status;
    private Date createdDate;
    private Date lastModifiedDate;

    public String getSendersPhone() {
        return sendersPhone;
    }

    public void setSendersPhone(String sendersPhone) {
        this.sendersPhone = sendersPhone;
    }

    public String getReceiversPhone() {
        return receiversPhone;
    }

    public void setReceiversPhone(String receiversPhone) {
        this.receiversPhone = receiversPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getExchangeRequestId() {
        return exchangeRequestId;
    }

    public void setExchangeRequestId(Integer exchangeRequestId) {
        this.exchangeRequestId = exchangeRequestId;
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
