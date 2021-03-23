package com.management.mapper;

import com.management.entity.PositionBean;
import com.management.entity.rsp.PositionRsp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface PositionMapper {

    List<PositionRsp> selectAllPosition(@Param("pname") String pname);

    int addPosition(@Param("dUuid") String dUuid,
                    @Param("pName") String pName,
                    @Param("creator") String creator,
                    @Param("introduction") String introduction);

    int deletePosition(@Param("uuid") String uuid);

    int updatePosition(@Param("uuid") String uuid,
                       @Param("pName") String pName,
                       @Param("creator") String creator,
                       @Param("introduction") String introduction);

    PositionBean selectPositionUuid(@Param("positionUuid") String positionUuid);
}
