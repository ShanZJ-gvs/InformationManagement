package com.gvssimux.service;

import com.gvssimux.pojo.Fangchan;
import com.gvssimux.pojo.User;

import java.util.List;

public interface UserService {

    int insertSelective(User record);

    //根据uname和uuid查询用户
    List<User> selectAllUser(String uname,String uuid);

    //通过产权人查房产
    List<Fangchan> getFByUname(String uname);


}
