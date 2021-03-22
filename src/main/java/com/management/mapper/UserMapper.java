package com.management.mapper;

import com.management.entity.UserBean;
import com.management.entity.UserInfoBean;
import com.management.entity.rsp.UserRsp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    UserBean selectByUserName(@Param("userName") String userName);

    UserBean login(@Param("userName") String userName, @Param("password") String password);

    List<UserRsp> selectAllUser(@Param("userName") String userName);

    int editUser(@Param("id") Integer id, @Param("name") String name, @Param("sex") String sex,
                 @Param("entryTime") Date entryTime, @Param("birthday") Date birthday, @Param("age") String age);

    int countDepartmentUser(@Param("department") String department);

    int countPositionUser(@Param("position") String position);

    int countBySex(@Param("sex") String sex);

    int regist(@Param("uuid") String uuid,
               @Param("userName") String userName,
               @Param("password") String password,
               @Param("statement") Integer statement,
               @Param("role") Integer role);

    int registUserInfo(@Param("uuid") String uuid,
                       @Param("name") String name);

    UserBean selectByUuid(@Param("uuid") String uuid);

    UserInfoBean selectByInfoUuid(@Param("uuid") String uuid);
}
