package com.shop.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Role implements Serializable {
    private Long id;
    private String roleName;
    private String roleDesc;
    private List<User> users;
    private List<Permission> permissions;
}
