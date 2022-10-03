package com.yupohsuan.batteryexchangesystem.util;

import java.util.List;

public class Page<T> {
    private Integer total;
    private List<T> result;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
