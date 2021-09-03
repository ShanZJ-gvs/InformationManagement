package com.gvssimux.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.Fangchan;
import com.gvssimux.pojo.User;
import com.gvssimux.service.FangchanServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

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

        return mapper.selectAllUser("单子健","3402000").toString();
    }

    /**
     * form-wizards.html中的提交房产信息
     */
    @ResponseBody
    @RequestMapping("/fanchanform")
    public void changeBook(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FangchanServiceImpl FangchanServiceImpl = context.getBean("FangchanServiceImpl", FangchanServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        //随机生成id
        String fid = String.valueOf(UUID.randomUUID());
        String uid = String.valueOf(UUID.randomUUID());
        //创建接收对象
        Fangchan object = new Fangchan();
//        设置默认属性，方便在数据库中查看哪错了
        object.setFid(fid);
        object.setUid(uid);
        object.setFname("从前端获取null");
        object.setFaddress("从前端获取null");
        object.setFarea1(0.0);
        object.setFarea2(0.0);
        object.setFcost(0.0);
        object.setIsloans(2);
        object.setIspay(2);

        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        //根据uname和uuid查询User
        if (request.getParameter("uname")!="" &&
                request.getParameter("uuid")!=""){
            String uname = request.getParameter("uname");
            String uuid = request.getParameter("uuid");
            List<User> users = mapper.selectAllUser(uname,uuid);
            if (users!=null){
                uid = users.get(0).getUid();
            }
            //**uname和uuid有值，但是没有查到这个人，那么插入*//


            //***************************************//
            System.out.println(users.toString());
        }





        System.out.println(111);
        System.out.println("根据uname查询User");
        System.out.println("fid  "+fid);
        System.out.println("uid  "+uid);





        //往对象中赋 真实数据
        object.setFid(fid);
        System.out.println(11111);
        object.setUid(uid);
        System.out.println(2222);
        object.setFname(request.getParameter("fname"));
        object.setFaddress(request.getParameter("faddress"));
        System.out.println(33333);
        System.out.println(request.getParameter("farea1"));

        if (request.getParameter("farea1")!=null&&
                request.getParameter("farea1")!=""&&
                request.getParameter("farea2")!=null&&
                request.getParameter("farea2")!=""&&
                request.getParameter("fcost")!=null&&
                request.getParameter("fcost")!=""){
            System.out.println(4444);
            object.setFarea1(Double.valueOf(request.getParameter("farea1")));
            object.setFarea2(Double.valueOf(request.getParameter("farea2")));
            object.setFcost(Double.valueOf(request.getParameter("fcost")));
            System.out.println(5555);
        }
        System.out.println(6666);
//        object.setIsloans(Integer.valueOf(request.getParameter("isloans")));
//        object.setIspay(Integer.valueOf(request.getParameter("ispay")));

        System.out.println("request.getParameter(\"fname\")"+request.getParameter("fname"));
        System.out.println("request.getParameter(\"faddress\")"+request.getParameter("faddress"));
        System.out.println("成功执行==》FanChanController");
        FangchanServiceImpl.insertSelective(object);

//        往user表中插入数据



    }


}
