package com.gvssimux.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FanChanController {

    //通过产权人查房产
    @ResponseBody  //使之不会走视图解析器，会直接返回一个字符串
    @RequestMapping("/getfbyu")//getFanchanByuname
    public String getFanchanByuname() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(mapper.getFByUname("单子健"));
        System.out.println("通过产权人查房产");
        return mapper.getFByUname("单子健").toString();
    }

    //根据uname查询User
    @ResponseBody
    @RequestMapping("/getUserByUname")
    public String getUserByUname(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);

        return mapper.selectAllUser("单子健").toString();


    }



}
