package com.management.mapper;

import com.management.entity.SignBean;
import com.management.entity.rsp.SignRsp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SignMapper {
    List<SignRsp> selectSignByUser(@Param("uuid") String uuid);

    int signIn(@Param("uuid") String uuid, @Param("uUuid") String uUuid, @Param("statement") Integer statement, @Param("describe") String describe);

    int signOut(@Param("uuid") String uuid, @Param("statement") Integer statement);
}
