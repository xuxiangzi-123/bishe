package com.management.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DepartmentBean {
    private int id;
    private String uuid;
    private String dName;
    private Date createTime;
    private Date updateTime;
    private String creator;
    private String introduction;
}
