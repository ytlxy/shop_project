package com.shop.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Helps implements Serializable {
    private Long help_id;
    private String help_name;
    private String help_url;
}
