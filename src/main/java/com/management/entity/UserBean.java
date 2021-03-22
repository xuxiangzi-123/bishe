package com.management.entity;

import lombok.Data;

@Data
public class UserBean {
    //id
    private int id;
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
}
