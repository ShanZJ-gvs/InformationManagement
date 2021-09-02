package com.gvssimux.service;

import com.gvssimux.dao.UserDao;
import com.gvssimux.dao.UserLoginDao;
import com.gvssimux.pojo.login.UserLogin;

import java.util.List;

public class UserLoginServiceImpl {
    private UserLoginDao mapper;
//
//    public int deleteByPrimaryKey(Integer id) {
//        return mapper.deleteByPrimaryKey(id);
//    }
//
//    public int insert(UserLogin record) {
//        return mapper.insert(record);
//    }
//
    public int insertSelective(UserLogin record) {
        return mapper.insertSelective(record);
    }
//
//    public UserLogin selectByPrimaryKey(Integer id) {
//        return mapper.selectByPrimaryKey(id);
//    }
//
//    public int updateByPrimaryKeySelective(UserLogin record) {
//        return mapper.updateByPrimaryKeySelective(record);
//    }
//
//    public int updateByPrimaryKey(UserLogin record) {
//        return mapper.updateByPrimaryKey(record);
//    }




    public List<UserLogin> selectAll(){
        return mapper.selectAll();
    }


    public UserLogin selectByUserId(String userid) {
        return mapper.selectByUserId(userid);
    }


    public int getUserNum() {
        return mapper.getUserNum();
    }


    public UserLogin getUserIdByUserNamePwd(String username, String pwd) {
        return mapper.getUserIdByUserNamePwd(username, pwd);
    }

    //2021-写
    //注册---验证用户名是否在数据中
    public int getUserByUser(String user){
        if (mapper.getUserByUser(user)==null){
            return 0;
        }
        if(mapper.getUserByUser(user).equals(user))
            return 1;
        return 0;
    }


    public void setMapper(UserLoginDao mapper) {
        this.mapper = mapper;
    }
}
