package com.management.service;

import com.management.entity.DepartmentBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.PositionRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionService {
    List<PositionRsp> selectAllPosition(String pname);
    Boolean addPosition(@Param("dUuid") String dUuid,
                        @Param("pName") String pName,
                        @Param("creator") String creator,
                        @Param("introduction") String introduction);
    Boolean deletePosition(@Param("dUuid") String dUuid);
    Boolean updatePosition(@Param("dUuid") String dUuid,
                           @Param("pName") String pName,
                           @Param("creator") String creator,
                           @Param("introduction") String introduction);

    List<EchartsRsp> count(String position);
}
