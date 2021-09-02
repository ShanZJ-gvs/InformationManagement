package com.gvssimux.service;

import com.gvssimux.pojo.login.UserLogin;

import java.util.List;

public interface UserLoginService {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(UserLogin record);
//
    int insertSelective(UserLogin record);
//
//    UserLogin selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(UserLogin record);
//
//    int updateByPrimaryKey(UserLogin record);

    //查询全部user，不带密码
    List<UserLogin> selectAll();

    //根据Id查询
    UserLogin selectByUserId(String userid);

    //查询用户数量
    int getUserNum();

    //登陆查询，使用用户名和密码登陆
    UserLogin getUserIdByUserNamePwd(String username, String pwd);

    //2021-写
    //注册---验证用户名是否在数据中
    int getUserByUser(String user);

}
