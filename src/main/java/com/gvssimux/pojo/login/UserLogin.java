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

    public UserLogin(String userid, String uname, String user, String pwd, String sign, Integer time) {
        this.userid = userid;
        this.uname = uname;
        this.user = user;
        this.pwd = pwd;
        this.sign = sign;
        this.time = time;
    }


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserLogin other = (UserLogin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUname() == null ? other.getUname() == null : this.getUname().equals(other.getUname()))
            && (this.getUser() == null ? other.getUser() == null : this.getUser().equals(other.getUser()))
            && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUname() == null) ? 0 : getUname().hashCode());
        result = prime * result + ((getUser() == null) ? 0 : getUser().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", uname=").append(uname);
        sb.append(", user=").append(user);
        sb.append(", pwd=").append(pwd);
        sb.append(", sign=").append(sign);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}