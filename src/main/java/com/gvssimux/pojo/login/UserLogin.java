package com.gvssimux.pojo.login;

import java.io.Serializable;
import lombok.Data;

/**
 * UserLogin
 * @author 
 */
@Data
public class UserLogin implements Serializable {
    /**
     * 后台生成的唯一标识
     */
    private Integer id;

    /**
     * uuid
     */
    private String userid;

    /**
     * 用户昵称
     */
    private String uname;

    /**
     * 登录名
     */
    private String user;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 身份(用户、管理)
     */
    private String sign;

    /**
     * 剩余借书的次数
     */
    private Integer time;

    private static final long serialVersionUID = 1L;

    public UserLogin(Integer id, String userid) {
        this.id = id;
        this.userid = userid;
    }

    public UserLogin(String userid, String uname, String sign) {
        this.userid = userid;
        this.uname = uname;
        this.sign = sign;
    }

    public UserLogin(String userid, String uname, String user, String pwd, String sign, Integer time) {
        this.userid = userid;
        this.uname = uname;
        this.user = user;
        this.pwd = pwd;
        this.sign = sign;
        this.time = time;
    }
}