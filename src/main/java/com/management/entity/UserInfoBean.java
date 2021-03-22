package com.management.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoBean {

    private int id;
    private String uuid;
    private String name;
    private String img;
    private String sex;
    private String age;
    private Date birthday;
    private Date entryTime;
    private String position;
    private String department;
    private Date createTime;
    private Date updateTime;

}
