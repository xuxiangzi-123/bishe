package com.management.service.serviceImpl;

import com.management.entity.UserBean;
import com.management.entity.UserInfoBean;
import com.management.entity.rsp.EchartsRsp;
import com.management.entity.rsp.PositionRsp;
import com.management.entity.rsp.UserRsp;
import com.management.mapper.UserMapper;
import com.management.service.UserService;
import com.management.utils.IDUtil;
import com.management.utils.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserBean selectByUserName(String userName) {
        if (userName != null){
            UserBean userBean = userMapper.selectByUserName(userName);
            if (userBean != null){
                return userBean;
            }
        }
        return null;
    }

    @Override
    public UserBean login(String userName, String password, HttpSession sess) {
        if (userName != null && password != null){
            UserBean login = userMapper.login(userName, password);
            if (login != null){
                sess.setAttribute("UserBean",login);
                return login;
            }
        }
        return null;
    }

    @Override
    public Boolean regist(String uuid, String userName, String password, Integer statement, Integer role) {
        uuid = IDUtil.genUUID();
        if (uuid == null){
            return false;
        }
        if (userName == null){
            return false;
        }
        if (password == null){
            return false;
        }
        statement = 0;
        role = 1;
        int regist = userMapper.regist(uuid, userName, password, statement, role);
        if (regist >0 ){
            int i = userMapper.registUserInfo(uuid, userName);
            if (i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserRsp> selectAllUser(String userName) {
        List<UserRsp> userRsp = userMapper.selectAllUser(userName);
        if (userRsp != null){
            return userRsp;
        }
        return null;
    }

    @Override
    public boolean editUser(Integer id ,String name, String sex, String entryTime, String birthday,String age) throws ParseException {
        UserRsp userRsp=new UserRsp();
        if (id != null){
            userRsp.setId(id);
        }
        if (name != null){
            userRsp.setName(name);
        }
        if (sex != null){
            userRsp.setSex(sex);
        }
        if (entryTime != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
            Date date = simpleDateFormat.parse(entryTime);
            userRsp.setEntryTime(date);
        }
        if (birthday != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
            Date date = simpleDateFormat.parse(entryTime);
            userRsp.setBirthday(date);
        }
        if (age != null){
            userRsp.setAge(age);
        }
        int i = userMapper.editUser(id,name,sex,userRsp.getEntryTime(),userRsp.getBirthday(),age);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public int countUserByDepartment( String department) {
        int i = userMapper.countDepartmentUser(department);
        return i;
    }

    @Override
    public int countPositionUser(String position) {
        int i = userMapper.countPositionUser(position);
        return i;
    }

    @Override
    public Boolean delete(String userId) {
        if (userId != null){
            int delete = userMapper.delete(userId);
            if (delete>0){
                int i = userMapper.deleteUser(userId);
                if (i>0){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public List<EchartsRsp> countBySex(String sex) {
        ArrayList<EchartsRsp> list=new ArrayList<>();
        List<String> sexy = new ArrayList<>();
        sexy.add("男");
        sexy.add("女");
        if (sexy != null){
            for (String s : sexy) {
                EchartsRsp echartsRsp=new EchartsRsp();
                if (s != null){
                    int i = userMapper.countBySex(s);
                    echartsRsp.setName(s);
                    echartsRsp.setNum(i);
                }
                list.add(echartsRsp);
            }

        }
        return list;
    }
}
