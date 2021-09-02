package com.gvssimux.controller;


import com.gvssimux.pojo.login.UserLogin;
import com.gvssimux.service.UserLoginServiceImpl;
import com.gvssimux.util.GetUUID;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/checkUserPwd")
    public String loginUser(HttpSession session, String username, String pwd) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserLoginServiceImpl mapper = context.getBean("UserLoginServiceImpl", UserLoginServiceImpl.class);
        UserLogin user = mapper.getUserIdByUserNamePwd(username, pwd);
        System.out.println("执行成功=====》:"+user);


        if (user!=null) {
            //把用户的信息存在session中,用于验证
            session.setAttribute("uuid",user);
            System.out.println("LoginController===>");
            return "UserPwdOK";
        }
        return "UserPwdError";

    }



    /**2021
     * 注册----验证用户名
     * 返回值:
     *      error0:输入不规范
     *      error1:输入用户名已经存在
     *      success0:表示此用户名可以注册
     */
    @ResponseBody
    @RequestMapping("/registerUser")
    public  String  registerUser (String user) {
        if (judgeContainsStr(user)&&isStrLength(user,4,8)){
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            UserLoginServiceImpl mapper = context.getBean("UserServiceImpl", UserLoginServiceImpl.class);
            //a为1则重复 若a为0不重复
            //执行查询
            int a = mapper.getUserByUser(user);
            System.out.println("执行成功registerUser=====》:"+user);
            if(a==0){
                System.out.println("success0");
                return "success0";
            }
            System.out.println("error1");
            return "error1";
        }
        System.out.println("error0");
        return "error0";

    }



    /**
     * 注册----验证昵称
     * 返回值:
     *      unameerror:昵称不规范
     *      unamesuccess:昵称符合规范
     */
    @ResponseBody
    @RequestMapping("/registerUname")
    public  String  registerUname (String uname) {
        if(isStrLength(uname,2,12)){
            System.out.println("unamesuccess");
            return "unamesuccess";
        }
        System.out.println("unameerror");
        return "unameerror";
    }


    /**
     * 注册----验证密码打于6  (设置了小于50，是防止字符过长，超出字符串长度)
     * 返回值:
     *      pwderror0:密码长度小于6或大于50
     *      pwderror1:密码不包含字母和数字
     *      pwdsuccess:OK
     */
    @ResponseBody
    @RequestMapping("/registerPWD")
    public  String  registerPWD (String pwd) {
        if(isStrLength(pwd,6,50)){
            if(HasDigit(pwd)&&judgeContainsStr2(pwd)){
                System.out.println("pwdsuccess");
                return "pwdsuccess";
            }
            System.out.println("pwderror1");
            return "pwderror1";
        }
        System.out.println("pwderror0");
        return "pwderror0";
    }


    /**
     * 验证 重输密码 是否一致
     * 返回值:
     *      pwd2error:不一致
     *      pwd2success:OK
     */
    @ResponseBody
    @RequestMapping("/registerPWD2")
    public  String  registerPWD2 (String pwd,String pwd2) {
        if (pwd.length()==0){
            System.out.println("pwderror3");
            return "pwderror3";
        }
        if (pwd2.equals(pwd)){
            System.out.println("pwd2success");
            return "pwd2success";
        }
        System.out.println("pwd2error");
        return "pwd2error";
    }


    /**
     * 点击注册按钮
     */
    @ResponseBody
    @RequestMapping("/setuser")
    public String setUser(HttpSession session,String uname,String user,String pwd,String pwd2){
        if (registerUser(user).equals("success0")&&
                registerUname(uname).equals("unamesuccess")&&
                registerPWD(pwd).equals("pwdsuccess")&&
                registerPWD2(pwd,pwd2).equals("pwd2success")){
            System.out.println("setUserSuccess");

            //插入用户信息
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            UserLoginServiceImpl mapper = context.getBean("UserServiceImpl", UserLoginServiceImpl.class);
            UserLogin user1 = new UserLogin(GetUUID.get(),uname,user,pwd2,"admin",5);
            System.out.println(mapper.insertSelective(user1));
            //创建session
            if (user!=null) {
                //把用户的信息存在session中,用于验证
                session.setAttribute("uuid",user);
                return "setUserSuccess";
            }

        }
        System.out.println("setUserError");
        return "setUserError";
    }


    @org.junit.Test
    public void  test(){
        System.out.println("①语句覆盖");
        registerUname("哈哈哈");
        registerUname("单");
        System.out.println("②判定覆盖");
        registerUname("小明同学");
        registerUname("笑");
        System.out.println("③条件覆盖");
        registerUname("小李同学");
        registerUname("天");
        System.out.println("④判定-条件覆盖");
        registerUname("小李同学");
        registerUname("吴");
        System.out.println("⑤组合覆盖");
        registerUname("小黄同学");
        registerUname("紫");
        System.out.println("⑥路径覆盖");
        registerUname("高同学");
        registerUname("杨");

    }


    @org.junit.Test
    public void  test1(){
        System.out.println("①语句覆盖");
        registerUser("shanzj");
        registerUser("123ws");
        registerUser("_12");
        registerUser("admin");
        System.out.println("②判定覆盖");
        registerUser("shanzj1");
        registerUser("12");
        registerUser("_ws");
        registerUser("admin");
        System.out.println("③条件覆盖④判定-条件覆盖⑤组合覆盖⑥路径覆盖");
        registerUser("shanzj");
        registerUser("12");
        registerUser("_ws");
        registerUser("admin");
        registerUser("admin12345678");

    }



    /*****************↓↓↓封装的方法↓↓↓********************/

    /**
     * 判断字符串是否以字母或_开头
     * @param str 待检验的字符串
     * @return 返回是否包含
     * true  以字母或_开头 ; false  不以字母或_开头
     */
    public boolean judgeContainsStr(String str) {
        String regex="[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(str);
        if(m.matches()==false){
            return str.startsWith("_");
        }
        return m.matches();
    }

    /**
     * 判断字符串是否包含字母
     * @param str 待检验的字符串
     * @return 返回是否包含
     * true: 是 ;false 否
     */
    public boolean judgeContainsStr2(String str) {
        String regex=".+[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(str);

        return m.matches();
    }


    /**
     * 判断一个字符串是否都为数字
     * @param str 待检验的字符串
     * @return
     * true: 是 ;false 否
     */
    public boolean isDigit(String str) {
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) str);
        return matcher.matches();
    }



    /**
     * 判断一个字符串是否含有数字
     * @param str 待检验的字符串
     * @return
     * true: 是 ;false 否
     */
    public boolean HasDigit(String str) {
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(str);

        return m.matches();
    }



    /**
     * 字符串的长度是否 a<=str<=b
     * @param str 待检验的字符串
     * @return 返回是否
     * true: 是 ;false 否
     */
    public static boolean isStrLength(String str,int a,int b) {
        if (a<=str.length()&&str.length()<=b){
            return true;
        }
        return false;
    }

    /***************↑↑↑封装的方法↑↑↑*************************/


}
