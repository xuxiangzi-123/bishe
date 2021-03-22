package com.management.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.entity.DepartmentBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.PositionRsp;
import com.management.service.serviceImpl.DepartmentServiceImpl;
import com.management.service.serviceImpl.PositionServiceImpl;
import com.management.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position/")
public class PositionController {

    @Autowired
    private PositionServiceImpl positionService;

    @RequestMapping("selectAllPosition")
    public PageInfo selectAllDepartment(int page,int limit,String pname){
        PageHelper.startPage(page, limit);
        List<PositionRsp> positionRsps = positionService.selectAllPosition(pname);
        PageInfo pageInfo = new PageInfo(positionRsps);
        return pageInfo;
    }
    @RequestMapping("addPosition")
    public BaseResponse addDepartment(String uuid, String dName, String creator, String introduction){
        BaseResponse baseResponse=new BaseResponse();
        if (positionService.addPosition(uuid,dName,creator,introduction)){
            baseResponse.setCode(1);
            baseResponse.setMessage("修改成功");
            return baseResponse;
        }
        baseResponse.setCode(-1);
        baseResponse.setMessage("修改失败");
        return baseResponse;
    }
    @RequestMapping("deletePosition")
    public BaseResponse deleteDepartment(String uuid){
        BaseResponse baseResponse=new BaseResponse();

        baseResponse.setCode(0);
        return baseResponse;
    }
    @RequestMapping("updatePosition")
    public BaseResponse updateDepartment(String uuid, String dName, String creator, String introduction){
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setCode(0);
        return baseResponse;
    }

    @RequestMapping("count")
    public List<EchartsRsp> countUserByDepartment(String department){
        List<EchartsRsp> count = positionService.count(department);
        return count;
    }
}
