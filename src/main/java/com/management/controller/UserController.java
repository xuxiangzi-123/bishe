package com.management.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.entity.UserBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.UserRsp;
import com.management.service.serviceImpl.UserServiceImpl;
import com.management.utils.BaseResponse;
import com.management.utils.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("selectByUserName")
    @ResponseBody
    public BaseResponse selectByUserName(String userName){
        BaseResponse baseResponse=new BaseResponse();
        UserBean userBean = userService.selectByUserName(userName);
        if (userBean != null){
            baseResponse.setCode(0);
            baseResponse.setMessage("用户名已存在");
            return baseResponse;
        }
        baseResponse.setCode(1);
        baseResponse.setMessage("");
        return baseResponse;
    }

    @RequestMapping("login")
    @ResponseBody
    public BaseResponse login(String userName, String password, HttpServletRequest req, HttpServletRequest request){
        BaseResponse baseResponse=new BaseResponse();

        UserBean login = userService.login(userName, password,req.getSession());

        if (login != null){
            baseResponse.setCode(1);
            baseResponse.setMessage("登陆成功");
            baseResponse.setData(login);
            return baseResponse;
        }
        baseResponse.setData(0);
        baseResponse.setMessage("用户名或密码输入错误");
        return baseResponse;
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("toUserList")
    public String toUserList(){
        return "userList";
    }

    @RequestMapping("toDepartment")
    public String toDepartment(){
        return "departmentList";
    }

    @RequestMapping("toPositionList")
    public String toPositionList(){
        return "positionList";
    }

    @RequestMapping("toSign")
    public String toSign(){
        return "sign";
    }

    @RequestMapping("toCountList")
    public String toCountList(){
        return "countList";
    }

    @RequestMapping("toTest")
    public String toTest(){
        return "Test";
    }

    @RequestMapping("/selectAllUser")
    @ResponseBody
    public PageInfo selectAllUser(int page,int limit,String userName){
        PageHelper.startPage(page, limit);
        List<UserRsp> userBeans = userService.selectAllUser(userName);
        PageInfo pageInfo = new PageInfo(userBeans);
        return pageInfo;
    }
    @RequestMapping("editUser")
    @ResponseBody
    public BaseResponse editUser(Integer id, String name, String sex, String entryTime, String birthday,String age) throws ParseException {
        BaseResponse baseResponse=new BaseResponse();
        if(userService.editUser(id,name,sex,entryTime,birthday,age)){
            baseResponse.setCode(1);
            baseResponse.setMessage("修改成功");
            return baseResponse;
        }
        baseResponse.setCode(0);
        baseResponse.setMessage("修改失败");
        return baseResponse;
    }
    @RequestMapping("count")
    @ResponseBody
    public List<EchartsRsp> countUserByDepartment(String sex){
        List<EchartsRsp> count = userService.countBySex(sex);
        return count;
    }

    @RequestMapping("regist")
    @ResponseBody
    public BaseResponse regist(String uuid, String userName, String password, Integer statement, Integer role){
        BaseResponse baseResponse = new BaseResponse();
        if (userService.regist(uuid, userName, password, statement, role)){
            baseResponse.setCode(1);
            baseResponse.setMessage("注册成功");
            return baseResponse;
        }
        baseResponse.setCode(0);
        return baseResponse;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public BaseResponse deleteUser(String uuid){
        BaseResponse baseResponse = new BaseResponse();
        if (userService.delete(uuid)){
            baseResponse.setCode(1);
        }else {
            baseResponse.setCode(0);
        }
        return baseResponse;
    }
}
