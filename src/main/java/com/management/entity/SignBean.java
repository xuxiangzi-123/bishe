package com.management.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SignBean {

    private Integer id;

    private String uuid;

    private String uUuid;

    private Date signInTime;

    private Date signOutTime;

    private Integer statement;

    private String describe;
}
