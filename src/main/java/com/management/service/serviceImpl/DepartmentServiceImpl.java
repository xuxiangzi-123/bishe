package com.management.service.serviceImpl;

import com.management.entity.DepartmentBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.PositionRsp;
import com.management.mapper.DepartmentMapper;
import com.management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PositionServiceImpl positionService;

    @Override
    public List<DepartmentBean> selectAllDepartment() {
        List<DepartmentBean> departmentBeans = departmentMapper.selectAllDepartment();
        if (departmentBeans != null){
            return departmentBeans;
        }
        return null;
    }

    @Override
    public boolean addDepartment(String uuid, String dName, String creator, String introduction) {
        return true;
    }

    @Override
    public boolean deleteDepartment(String uuid) {
        if (uuid !=null){
            int i = departmentMapper.deleteDepartment(uuid);
            if (i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateDepartment(String uuid, String dName, String creator, String introduction) {
        int i = departmentMapper.updateDepartment(uuid, dName, creator, introduction);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<DepartmentBean> selectByDepartmentName(String name) {
        List<DepartmentBean> departmentBeans = departmentMapper.selectAllByDepartmentName(name);
        return departmentBeans;
    }

    @Override
    public  List<EchartsRsp> count(String department) {
        ArrayList<EchartsRsp> list=new ArrayList<>();
            List<DepartmentBean> departmentBeans = this.selectAllDepartment();
            if (departmentBeans != null){
                for (DepartmentBean departmentBean : departmentBeans) {
                    EchartsRsp echartsRsp=new EchartsRsp();
                    if (departmentBean != null){
                        int i = userService.countUserByDepartment(departmentBean.getUuid());
                        echartsRsp.setName(departmentBean.getDName());
                        echartsRsp.setNum(i);
                    }
                    list.add(echartsRsp);
                }

            }
        return list;
    }
}
