package com.shop.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private Long id;
    private String permissionName;
    private String url;
}
