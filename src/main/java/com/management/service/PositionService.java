package com.management.service;

import com.management.entity.DepartmentBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.PositionRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionService {
    List<PositionRsp> selectAllPosition(String pname);

    Boolean addPosition(String dUuid,
                        String pName,
                        String creator,
                        String introduction);

    Boolean deletePosition(String dUuid);

    Boolean updatePosition(String dUuid,
                           String pName,
                           String introduction);

    List<EchartsRsp> count(String position);
}
