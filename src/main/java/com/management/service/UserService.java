package com.management.service;

import com.management.entity.UserBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.UserRsp;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface UserService {

    UserBean selectByUserName(String userName);

    UserBean login(String userName, String password);

    Boolean regist(String uuid,
                   String userName,
                   String password,
                   Integer statement,
                   Integer role);

    List<UserRsp> selectAllUser(String userName);

    boolean editUser(Integer id, String name, String sex, String entryTime, String birthday, String age) throws ParseException;

    int countUserByDepartment(String department);

    int countPositionUser(String position);

    List<EchartsRsp> countBySex(String sex);
}
