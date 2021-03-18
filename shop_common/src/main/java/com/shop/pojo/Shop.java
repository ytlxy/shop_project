package com.shop.pojo;

import com.shop.util.DateUtils;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ToString
public class Shop implements Serializable {
    private Long shop_id;
    private String shop_name;
    private Double shop_money;
    private String shop_synopsis;
    private String shop_img;
    private Date shop_time;
    private String shop_timeStr;
    private Integer status;
    private String statusStr;
    private List<Shop> shops;
    private Integer discount;
    private String discountStr;

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDiscountStr() {
        if (discount != null)
            if (discount == 0)
                discountStr="未打折";
            if (discount == 1)
                discountStr="打折";
        return discountStr;
    }

    public void setDiscountStr(String discountStr) {
        this.discountStr = discountStr;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
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

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Double getShop_money() {
        return shop_money;
    }

    public void setShop_money(Double shop_money) {
        this.shop_money = shop_money;
    }

    public String getShop_synopsis() {
        return shop_synopsis;
    }

    public void setShop_synopsis(String shop_synopsis) {
        this.shop_synopsis = shop_synopsis;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public Date getShop_time() {
        return shop_time;
    }

    public void setShop_time(Date shop_time) {
        this.shop_time = shop_time;
    }

    public String getShop_timeStr() {
        shop_timeStr= DateUtils.date2string(getShop_time(), "yyyy-MM-dd HH:mm:ss");
        return shop_timeStr;
    }

    public void setShop_timeStr(String shop_timeStr) {
        this.shop_timeStr = shop_timeStr;
    }
}
