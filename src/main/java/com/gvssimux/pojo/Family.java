package com.gvssimux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Family {
    //家庭编号
    private String jtbh;
    //姓名
    private String xm;
    //行业
    private String hy;
    //备注
    private String bz;

    /*
     * 提供set和get，toString方法
     */
}