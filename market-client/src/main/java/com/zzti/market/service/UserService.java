package com.zzti.market.service;


import com.zzti.market.entity.User;

public interface UserService {
    String register(User user);
    String login(User user);
    String putUserInfo(User user);
    boolean checklogin();
    boolean appChecklogin(String token,String userId);
}
