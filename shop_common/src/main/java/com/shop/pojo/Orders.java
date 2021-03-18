package com.shop.pojo;

import com.shop.util.DateUtils;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Orders implements Serializable {
    private Long order_id;
    private String order_name;
    private String order_money;
    private String order_synopsis;
    private Date order_time;
    private String order_timeStr;
    private Long order_shop;
    private Shop shops;
    private Integer status;
    private String statusStr;
    private Integer allMoney;

    public Orders() {
    }

    public Long getOrder_shop() {
        return order_shop;
    }

    public void setOrder_shop(Long order_shop) {
        this.order_shop = order_shop;
    }

    public Integer getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Integer allMoney) {
        this.allMoney = allMoney;
    }

    public Shop getShops() {
        return shops;
    }

    public void setShops(Shop shops) {
        this.shops = shops;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status !=null)
            if (status ==0)
                statusStr="关闭";
        if (status ==1)
            statusStr="开启";
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_money() {
        return order_money;
    }

    public void setOrder_money(String order_money) {
        this.order_money = order_money;
    }

    public String getOrder_synopsis() {
        return order_synopsis;
    }

    public void setOrder_synopsis(String order_synopsis) {
        this.order_synopsis = order_synopsis;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getOrder_timeStr() {
        order_timeStr= DateUtils.date2string(order_time,"yyyy-MM-dd HH:mm:ss");
        return order_timeStr;
    }

    public void setOrder_timeStr(String order_timeStr) {
        this.order_timeStr = order_timeStr;
    }
}
