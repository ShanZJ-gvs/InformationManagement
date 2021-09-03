package com.gvssimux.dao;

import com.gvssimux.pojo.Fangchan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface FangchanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Fangchan record);

    //部分插入
    int insertSelective(Fangchan record);

    Fangchan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fangchan record);

    int updateByPrimaryKey(Fangchan record);


    //单个查询
    @Select("select * from jijianxiecha.fangchan where fid=#{c}")
    Fangchan getFByFid(@Param("c") String fid);

    //根据fid查询房产信息
    @Select("select * from jijianxiecha.fangchan where fid=#{a}")
    List<Fangchan> selectAllFanchan(@Param("a") String fid);

    //根据房屋地址名模糊查询房产
    @Select("select * from jijianxiecha.fangchan where faddress LIKE CONCAT('%',#{b},'%') ")
    List<Fangchan> getLikeFanchanByAddress(@Param("b") String faddress);


    



}