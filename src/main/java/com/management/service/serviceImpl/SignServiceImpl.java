package com.management.service.serviceImpl;

import com.management.entity.PositionBean;
import com.management.entity.SignBean;
import com.management.entity.UserBean;
import com.management.entity.UserInfoBean;
import com.management.entity.rsp.SignRsp;
import com.management.mapper.PositionMapper;
import com.management.mapper.SignMapper;
import com.management.mapper.UserMapper;
import com.management.service.SignService;
import com.management.utils.IDUtil;
import com.management.utils.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignMapper signMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<SignRsp> selectSignByUser(String uuid) {
        if (uuid != null){
            List<SignRsp> signRsps = signMapper.selectSignByUser(uuid);

            if (signRsps != null){
                for (SignRsp signRsp : signRsps) {
                    UserBean userBean = userMapper.selectByUuid(signRsp.getUUuid());
                    if(userBean != null){
                        signRsp.setUserName(userBean.getUserName());
                    }
                }
            }
            return signRsps;
        }
        return null;
    }

    @Override
    public Boolean signIn(String uuid,String uUuid,Integer statement, String describe) {
        UserBean user = UserInfoUtils.getUser();
        if (user != null){
            uUuid=user.getUuid();
        }
        if (statement == null){
            UserInfoBean userInfoBean = userMapper.selectByInfoUuid(uUuid);
            if (userInfoBean != null){
                String position = userInfoBean.getPosition();
                if (position != null){
                    PositionBean positionBean = positionMapper.selectPositionUuid(position);
                    if (position != null){
                        Date inTime = positionBean.getInTime();
                        Date date = new Date();
                        if (date.before(inTime)){
                            statement = 1;//迟到
                        }else {
                            statement = 0;//正常签到
                        }
                    }
                }
            }
        }else {
            if (describe == null){
                return false;
            }
        }

        String uuid1 = IDUtil.genUUID();
        if (uuid1 != null){
            uuid=uuid1;
        }
        int i = signMapper.signIn(uuid,uUuid,statement, describe);

        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean signOut(String uuid,Integer statement) {
        UserBean user = UserInfoUtils.getUser();
        String uUuid =null;
        if (user != null){
            uUuid=user.getUuid();
        }
        UserInfoBean userInfoBean = userMapper.selectByInfoUuid(uUuid);
        if (userInfoBean != null){
            String position = userInfoBean.getPosition();
            if (position != null){
                PositionBean positionBean = positionMapper.selectPositionUuid(position);
                if (position != null){
                    Date outTime = positionBean.getOutTime();
                    Date date = new Date();
                    if (outTime.before(date)){
                        statement = 2;//早退
                    }else {
                        statement = 0;//正常签退
                    }
                }
            }
        }
        int i = signMapper.signOut(uuid, statement);
        if (i>0){
            return true;
        }
        return false;
    }
}
