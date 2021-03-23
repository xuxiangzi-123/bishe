package com.management.service;

import com.management.entity.UserBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.UserRsp;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface UserService {

    UserBean selectByUserName(String userName);

    UserBean login(String userName, String password, HttpSession sess);

    Boolean regist(String uuid,
                   String userName,
                   String password,
                   Integer statement,
                   Integer role);

    List<UserRsp> selectAllUser(String userName);

    boolean editUser(Integer id, String name, String sex, String entryTime, String birthday, String age) throws ParseException;

    int countUserByDepartment(String department);

    int countPositionUser(String position);

    Boolean delete(String userId);

    List<EchartsRsp> countBySex(String sex);
}
