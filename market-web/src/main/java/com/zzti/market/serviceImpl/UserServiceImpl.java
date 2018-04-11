package com.zzti.market.serviceImpl;

import com.zzti.market.util.AESUtil;
import net.sf.json.JSONObject;
import com.zzti.market.dao.UserDao;
import com.zzti.market.entity.User;
import com.zzti.market.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService{

    private  static final String md5Key="vVwU4bhXdlSjWHMjxpCcbg==";
    @Resource
    private UserDao userDao;

    private  User user;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    public String register(User user) {
        int userCount=userDao.getCountByUserId(user.getUserId());
        JSONObject rejson = new JSONObject();
        if(userCount==0){
           int in= userDao.addUser(user);
           if(in==1){
               rejson.put("statusCode", "1");
               rejson.put("statusMes", "注册成功！跳转到登录界面!");
           }else {
               rejson.put("statusCode", "200");
               rejson.put("statusMes", "注册失败！添加用户异常！");
           }
        }else if(userCount==1){
            rejson.put("statusCode", "0");
            rejson.put("statusMes", "注册失败！该账号已被注册！");
        }
    return  rejson.toString();
    }

    public String login(User user) {
        int userCount=userDao.getCountByUserId(user.getUserId());
        JSONObject rejson = new JSONObject();
        if(userCount==0){
            rejson.put("statusCode", "0");
            rejson.put("statusMes", "该账号不存在！");
        }else if(userCount==1){
            int check=userDao.loginCheck(user.getUserId(),user.getPassWord());
            if(check==1) {
                String token=AESUtil.getSignature(user.getUserId(),md5Key);
                rejson.put("statusCode", "1");
                rejson.put("statusMes", "登录成功！");
                rejson.put("token",token);
            }else if(check==0){
                rejson.put("statusCode", "0");
                rejson.put("statusMes", "密码错误！");
            }
        }
        return rejson.toString();
    }

    @Override
    public User getUserInfo(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfo(String userId,
                              String userName,
                              String userSchool,
                              String telphone,
                              String email) {
        user=new User();
        user.setUserId(userId);
        user.setUserName(userName);
        if(StringUtils.isNotEmpty(userSchool)) {
            user.setUserSchool(userSchool);
        }
        user.setTelphone(telphone);
        user.setEmail(email);
        try {
            return userDao.updateByPrimaryKeySelective(user);
        } catch (DataAccessException e) {
            throw new RuntimeException("updateUserInfo Exception");
        }

    }

}

