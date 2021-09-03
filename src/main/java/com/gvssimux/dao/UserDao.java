package com.gvssimux.dao;

import com.gvssimux.pojo.Fangchan;
import com.gvssimux.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    //根据uname和uuid查询User
    @Select("select * from jijianxiecha.user where uname = #{a} and uuid=#{b}")
    List<User> selectAllUser(@Param("a") String uname,@Param("b") String uuid);

    //通过产权人查房产
    @Select("SELECT\n" +
            "\tjijianxiecha.fangchan.*\n" +
            "FROM\n" +
            "\tjijianxiecha.user\n" +
            "\tINNER JOIN\n" +
            "\tjijianxiecha.fangchan\n" +
            "\tON \n" +
            "\t\tuser.fid = fangchan.fid\n" +
            "WHERE\n" +
            "\t`user`.uname = #{b}\n" +
            "\t")
    List<Fangchan> getFByUname(@Param("b")String uname);




}