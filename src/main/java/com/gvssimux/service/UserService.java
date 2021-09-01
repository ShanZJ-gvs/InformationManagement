package com.gvssimux.service;

import com.gvssimux.pojo.Fangchan;
import com.gvssimux.pojo.User;

import java.util.List;

public interface UserService {

    //根据uname查询用户
    List<User> selectAllUser(String uname);

    //通过产权人查房产
    List<Fangchan> getFByUname(String uname);


}
