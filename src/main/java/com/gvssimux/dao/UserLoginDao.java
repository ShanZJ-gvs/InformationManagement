package com.gvssimux.dao;

import com.gvssimux.pojo.login.UserLogin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserLoginDao {
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
    @Select("select userid,uname,`user`,sign,time from bms.user")
    List<UserLogin> selectAll();

    //根据Id查询
    @Select("select * from bms.user where userid = #{userid}")
    UserLogin selectByUserId(@Param("userid") String userid);

    //查询用户数量
    @Select("SELECT COUNT(*) FROM bms.user")
    int getUserNum();

    //登陆查询，使用用户名和密码登陆
    @Select("select uname,userid,sign from bms.user where user = #{username} && pwd = #{pwd} && sign = 'admin'")
    UserLogin getUserIdByUserNamePwd(@Param("username")String username, @Param("pwd")String pwd);

    //2021-写
    //注册---验证用户名是否在数据中
    @Select("SELECT user from bms.user where user=#{user}")
    String getUserByUser(@Param("user")String user);

}