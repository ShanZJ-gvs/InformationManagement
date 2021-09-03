package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class testmvc {



    @RequestMapping("/test2")//页面跳转
    public String json01() throws JsonProcessingException {

        return "tiaozhuantest";
    }

    //通过产权人查房产
    @ResponseBody  //使之不会走视图解析器，会直接返回一个字符串
    @RequestMapping("/test1")
    public String tt3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(mapper.getFByUname("单子健"));
        System.out.println("通过产权人查房产");
        return mapper.getFByUname("单子健").toString();
    }



}
