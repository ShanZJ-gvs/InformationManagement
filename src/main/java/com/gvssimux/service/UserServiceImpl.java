package com.gvssimux.service;

import com.gvssimux.dao.FangchanDao;
import com.gvssimux.dao.UserDao;
import com.gvssimux.pojo.Fangchan;
import com.gvssimux.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao mapper;
    private FangchanDao FDao;

    public int insertSelective(User record){
        return mapper.insertSelective(record);
    }

    @Override
    public List<User> selectAllUser(String uname,String uuid) {
        return mapper.selectAllUser(uname,uuid);
    }


    //通过产权人查房产
    @Override
    public List<Fangchan> getFByUname(String uname) {

        return mapper.getFByUname("单子健");
    }


    public void setMapper(UserDao mapper) {
        this.mapper = mapper;
    }

    public void setFDao(FangchanDao FDao) {
        this.FDao = FDao;
    }
}
