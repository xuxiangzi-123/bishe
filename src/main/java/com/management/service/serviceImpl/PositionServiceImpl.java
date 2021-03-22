package com.management.service.serviceImpl;

import com.management.entity.DepartmentBean;
import com.management.entity.UserBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.PositionRsp;
import com.management.mapper.PositionMapper;
import com.management.service.PositionService;
import com.management.utils.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<PositionRsp> selectAllPosition(String pname) {
        List<PositionRsp> positionRsps = positionMapper.selectAllPosition(pname);
        if (positionRsps != null){
            return positionRsps;
        }
        return null;
    }

    @Override
    public Boolean addPosition(String dUuid, String pName, String creator, String introduction) {
        UserBean user = UserInfoUtils.getUser();
        String uuid = user.getUuid();
        if (uuid != null) {
            creator = uuid;
        }
        System.out.println(uuid);
        int i = positionMapper.addPosition(dUuid, pName, creator, introduction);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deletePosition(String dUuid) {
       return false;
    }

    @Override
    public Boolean updatePosition(String dUuid, String pName, String creator, String introduction) {
        return false;
    }

    @Override
    public List<EchartsRsp> count(String position) {
        ArrayList<EchartsRsp> list=new ArrayList<>();
        List<PositionRsp> positionRsps = this.selectAllPosition(null);
        if (positionRsps != null){
            for (PositionRsp positionRsp : positionRsps) {
                EchartsRsp echartsRsp=new EchartsRsp();
                if (positionRsp != null){
                    int i = userService.countUserByDepartment(positionRsp.getUuid());
                    echartsRsp.setName(positionRsp.getPName());
                    echartsRsp.setNum(i);
                }
                list.add(echartsRsp);
            }

        }
        return list;
    }
}
