package com.ypy.mallproduct.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Product {

    private Integer pid;

    private String pname;

    private String type;

    private Double price;

    private Timestamp createTime;

}
