package com.shop.pojo;

import com.shop.util.DateUtils;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ToString
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String user_email;
    private Double user_money;
    private String user_header;
    private Date user_time;
    private String user_timeStr;
    private Integer status;
    private String statusStr;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status != null) {
            if (status == 0)
                statusStr = "拒绝访问";
            if (status == 1)
                statusStr = "允许访问";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Double getUser_money() {
        return user_money;
    }

    public void setUser_money(Double user_money) {
        this.user_money = user_money;
    }

    public String getUser_header() {
        return user_header;
    }

    public void setUser_header(String user_header) {
        this.user_header = user_header;
    }

    public Date getUser_time() {
        return user_time;
    }

    public void setUser_time(Date user_time) {
        this.user_time = user_time;
    }

    public String getUser_timeStr() {
        user_timeStr = DateUtils.date2string(user_time, "yyyy-MM-dd HH:mm:ss");
        return user_timeStr;
    }

    public void setUser_timeStr(String user_timeStr) {
        this.user_timeStr = user_timeStr;
    }
}
