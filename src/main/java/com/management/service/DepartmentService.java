package com.management.service;

import com.management.entity.DepartmentBean;
import com.management.entity.rsp.EchartsRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<DepartmentBean> selectAllDepartment();
    boolean addDepartment(String uuid,
                          String dName,
                          String creator,
                          String introduction);
    boolean deleteDepartment(String uuid);

    boolean updateDepartment(String uuid,
                             String dName,
                             String creator,
                             String introduction);

    List<DepartmentBean> selectByDepartmentName(String name);

    List<EchartsRsp> count(String department);
}
