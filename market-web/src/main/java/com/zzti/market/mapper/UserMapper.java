package com.zzti.market.mapper;

import com.zzti.market.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: yzx
 * @Description:
 * @Date: Create in 14:37 2018/3/19
 */
public interface UserMapper {


    /**
     * @Author: yzx
     * @Description:
     * @Date: 14:54 2018/3/19
     * @param:  用户注册添加账号
     */
    int addUser(User record);
    /**
     * @Author: yzx
     * @Description: 判断用户名是否存在
     * @Date: 10:38 2018/3/17
     * @param:
     */
    int getCountByUserId(String userid);

    /**
     * @Author: yzx
     * @Description: 登陆验证，判断用户名密码是否正确
     * @Date: 10:39 2018/3/17
     * @param userId 用户名
     * @param passWord  密码
     */
    int loginCheck( @Param("userId")String userId, @Param("passWord")String passWord);

    User selectByPrimaryKey(@Param("userId")String userId);

    int updateByPrimaryKeySelective(User user);
}
