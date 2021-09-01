package com.gvssimux.service;

import com.gvssimux.pojo.Fangchan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FangchanService {

    //单个查询
    Fangchan getFByFid(String fid);

    //根据fid查询房产信息
    List<Fangchan> selectAllFanchan(String fid);

    //根据房屋地址名模糊查询房产
    List<Fangchan> getLikeFanchanByAddress(String faddress);


}
