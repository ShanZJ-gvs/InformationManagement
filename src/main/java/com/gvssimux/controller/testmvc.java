package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.login.UserLogin;
import com.gvssimux.service.FangchanServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testmvc {

    @ResponseBody  //使之不会走视图解析器，会直接返回一个字符串
    @RequestMapping("/j1")
    public String json01() throws JsonProcessingException {
        UserLogin user = new UserLogin(1,"单子健");
        return user.toString();
    }


    /**
     * 根据fid查询房产信息
     */
    @ResponseBody  //使之不会走视图解析器，会直接返回一个字符串
    @RequestMapping("/t1")
    public String tt1() throws JsonProcessingException {

        return "wadwad";
    }



    /**
     * 点击注册按钮跳转到注册页面
     */
    @RequestMapping("/toregister")
    public String toRegister(){

        return "register";
    }
}
