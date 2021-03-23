package com.management.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.entity.DepartmentBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.service.serviceImpl.DepartmentServiceImpl;
import com.management.utils.BaseResponse;
import com.management.utils.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department/")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @RequestMapping("selectAllDepartment")
    public PageInfo selectAllDepartment(int page,int limit,String dname){
        PageHelper.startPage(page, limit);
        List<DepartmentBean> departmentBeans = departmentService.selectByDepartmentName(dname);
        PageInfo pageInfo = new PageInfo(departmentBeans);
        return pageInfo;
    }

    @RequestMapping("selectAll")
    public BaseResponse selectAll(){
        BaseResponse baseResponse=new BaseResponse();
        List<DepartmentBean> departmentBeans = departmentService.selectAllDepartment();
         if (departmentBeans != null){
             baseResponse.setCode(1);
             baseResponse.setData(departmentBeans);
             return baseResponse;
         }
        return null;
    }
    @RequestMapping("addDepartment")
    public BaseResponse addDepartment(String uuid, String dName, String creator, String introduction){
        BaseResponse baseResponse=new BaseResponse();
        return baseResponse;
    }
    @RequestMapping("deleteDepartment")
    public BaseResponse deleteDepartment(String uuid){
        BaseResponse baseResponse=new BaseResponse();
        if (departmentService.deleteDepartment(uuid)) {
            baseResponse.setCode(1);
            baseResponse.setMessage("删除成功");
            return baseResponse;
        }
        baseResponse.setCode(0);
        return baseResponse;
    }
    @RequestMapping("updateDepartment")
    public BaseResponse updateDepartment(String uuid, String dName, String creator, String introduction){
        BaseResponse baseResponse=new BaseResponse();
        if (departmentService.updateDepartment(uuid,dName,creator,introduction)) {
            baseResponse.setCode(1);
            baseResponse.setMessage("修改成功");
            return baseResponse;
        }
        baseResponse.setCode(0);
        return baseResponse;
    }

    @RequestMapping("count")
    public List<EchartsRsp> countUserByDepartment(String department){
        List<EchartsRsp> count = departmentService.count(department);
        return count;
    }
}
