package com.management.mapper;

import com.management.entity.DepartmentBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    List<DepartmentBean> selectAllDepartment();
    int addDepartment(@Param("uuid") String uuid,
                      @Param("dName") String dName,
                      @Param("creator") String creator,
                      @Param("introduction") String introduction);
    int deleteDepartment(@Param("uuid") String uuid);
    int updateDepartment(@Param("uuid") String uuid,
                         @Param("dName") String dName,
                         @Param("creator") String creator,
                         @Param("introduction") String introduction);

    List<DepartmentBean> selectAllByDepartmentName(@Param("name") String name);
}
