package com.management.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PositionBean {
    private String uuid;

    private String dUuid;

    private String pName;

    private String introduction;

    private Date createTime;

    private Date updateTime;

    private String creator;

    private Date inTime;

    private Date outTime;
}
