package com.zzti.market.dao.daoImpl;


import com.zzti.market.dao.UserDao;
import com.zzti.market.entity.User;
import com.zzti.market.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao{

    @Resource
    private UserMapper userMapper;

//.00

//
//    User queryUserInfoid(String userid);
//

//
//    User queryUserInfo(String username);
//
//    User queryUserInfoemail(String email);
//
//    void updateUser(User user);
//
//    User updateUser(String userid);
//
//    User findUserById(String id);

     public  int addUser(User record){
         return  userMapper.addUser(record);
     }
    /**
     * @Author: yzx
     * @Description: 判断用户名是否存在
     * @Date: 10:38 2018/3/17
     * @param:
     */
    public int getCountByUserId(String userId){
        return userMapper.getCountByUserId(userId);
    }

    /**
     * @Author: yzx
     * @Description: 登陆验证，判断用户名密码是否正确
     * @Date: 10:39 2018/3/17
     * @param userId 用户名
     * @param password  密码
     */
    public int loginCheck( @RequestParam("userId")String userId,@RequestParam("password")String password){
        return  userMapper.loginCheck(userId,password);
    }
    public User selectByPrimaryKey(@Param("userId")String userId){
        return  userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

}