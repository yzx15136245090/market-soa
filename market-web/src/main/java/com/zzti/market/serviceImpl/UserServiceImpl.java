package com.zzti.market.serviceImpl;

import com.zzti.market.util.AESUtil;
import net.sf.json.JSONObject;
import com.zzti.market.dao.UserDao;
import com.zzti.market.entity.User;
import com.zzti.market.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private  static final String md5Key="vVwU4bhXdlSjWHMjxpCcbg==";
    @Resource
    private UserDao userDao;
    @Autowired
    private HttpSession session;

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
                Map seMap=new HashMap();
                String  token = AESUtil.getSignature(user.getUserId(),md5Key);
                session.setAttribute("userMap", seMap);
                seMap.put("token",token);
                seMap.put("userId",user.getUserId());
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
    public String putUserInfo(User user)
    {
        JSONObject rejson = new JSONObject();
        return  rejson.toString();
    }
    public  boolean checklogin(){
        Map userMap=(Map)session.getAttribute("user");
        String token=userMap.get("token").toString();
        String userId=userMap.get("userId").toString();
        if(!"".equals(token)&&!"".equals(userId))
        {
            return  true;
        }else {
            return  false;
        }
    }
    public boolean appChecklogin(String token,String userId){
        Map userMap=(Map)session.getAttribute("user");
        String mytoken=userMap.get("token").toString();
        String myuserId=userMap.get("userId").toString();
        if(mytoken.equals(token)&&myuserId.equals(userId))
        {
            return  true;
        }else {
            return  false;
        }
    }

}

