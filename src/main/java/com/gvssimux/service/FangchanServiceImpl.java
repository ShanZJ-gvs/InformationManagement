package com.gvssimux.service;

import com.gvssimux.dao.FangchanDao;
import com.gvssimux.pojo.Fangchan;
import com.gvssimux.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public class FangchanServiceImpl implements FangchanService{

    private FangchanDao mapper;

    //部分插入
    public int insertSelective(Fangchan record){
        System.out.println("执行成功==》FangchanServiceImpl 部分插入房产");
        return mapper.insertSelective(record);
    }

    //单个查询
    public Fangchan getFByFid(String fid){
        return mapper.getFByFid(fid);
    }

    public List<Fangchan> selectAllFanchan(String fid){
        return mapper.selectAllFanchan(fid);
    }

    public List<Fangchan> getLikeFanchanByAddress(String faddress){
        return mapper.getLikeFanchanByAddress(faddress);
    }



    public void setMapper(FangchanDao mapper) {
        this.mapper = mapper;
    }
}
