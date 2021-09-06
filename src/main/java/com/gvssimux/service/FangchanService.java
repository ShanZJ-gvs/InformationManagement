package com.gvssimux.service;

import com.gvssimux.pojo.Fangchan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FangchanService {

    //部分插入
    int insertSelective(Fangchan record);

   /* //部分插入--数据集
    int insertSelective2(List<Fangchan> record);*/

    //单个查询
    Fangchan getFByFid(String fid);

    //根据fid查询房产信息
    List<Fangchan> selectAllFanchan(String fid);

    //根据fid查询房产信息
    List<Fangchan> selectAllF();

    //根据房屋地址名模糊查询房产
    List<Fangchan> getLikeFanchanByAddress(String faddress);


}
