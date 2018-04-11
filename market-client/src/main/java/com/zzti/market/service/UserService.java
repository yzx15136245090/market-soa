package com.zzti.market.service;


import com.zzti.market.entity.User;


public interface UserService {
    String register(User user);
    String login(User user);
   // User queryUserInfo(User user);
    User getUserInfo(String userId);
    int updateUserInfo(String userId,
                      String userName,
                      String userSchool,
                       String telphone,
                       String email);
   // boolean checklogin();
   //boolean appChecklogin(String token,String userId);
}
