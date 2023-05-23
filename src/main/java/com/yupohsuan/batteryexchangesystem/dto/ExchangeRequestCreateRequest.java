package com.yupohsuan.batteryexchangesystem.dto;

public class ExchangeRequestCreateRequest {
    private String sendersPhone;
    private String receiversPhone;
    private String status;

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
}
