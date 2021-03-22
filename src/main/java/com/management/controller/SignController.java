package com.management.controller;

import com.management.entity.rsp.DataRsp;
import com.management.entity.rsp.SignRsp;
import com.management.service.serviceImpl.SignServiceImpl;
import com.management.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sign/")
public class SignController {
    @Autowired
    private SignServiceImpl signService;

    @RequestMapping("signIn")
    public BaseResponse signIn(String uuid,String uUuid,Integer statement, String describe){
        BaseResponse baseResponse = new BaseResponse();
        if (signService.signIn(uuid, uUuid, statement, describe)){
            baseResponse.setCode(1);
            baseResponse.setMessage("签到成功");
            return baseResponse;
        }
        baseResponse.setMessage("签到失败");
        baseResponse.setCode(0);
        return baseResponse;
    }
    @RequestMapping("signOut")
    public BaseResponse signOut(String uuid,Integer statement){
        BaseResponse baseResponse = new BaseResponse();
        if (signService.signOut(uuid, statement)){
            baseResponse.setCode(1);
            baseResponse.setMessage("签退成功");
            return baseResponse;
        }
        baseResponse.setMessage("签退失败");
        baseResponse.setCode(0);
        return baseResponse;
    }

    @RequestMapping("getSignData")
    @ResponseBody
    public List<DataRsp> calendarDate(String uuid){
        List<SignRsp> signRsps = signService.selectSignByUser(uuid);
        if (signRsps != null){
            List<DataRsp> dataRspList= new ArrayList<>();
            for (SignRsp signRsp : signRsps) {
                DataRsp dataRsp = new DataRsp();
                Date signInTime = signRsp.getSignInTime();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                String date = simpleDateFormat.format(signInTime);
                String data = signRsp.getDescribe()+" "+signRsp.getStatement();
                dataRsp.setDate(date);
                dataRsp.setData(data);
                dataRspList.add(dataRsp);
            }
          return dataRspList;
        }
        return null;
    }
}
