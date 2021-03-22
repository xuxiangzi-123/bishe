package com.management.entity.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserRsp implements Serializable {
    //唯一标识
    private String uuid;
    //用户名
    private String userName;
    //登陆密码
    private String password;
    //账号状态
    private int statement;
    //权限
    private int role;

    private int id;
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
