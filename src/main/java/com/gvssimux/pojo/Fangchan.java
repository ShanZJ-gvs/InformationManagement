package com.gvssimux.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * fangchan
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fangchan implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 房产信息唯一标识
     */
    private String fid;

    /**
     * usr表唯一标识
     */
    private String uid;

    /**
     * 房产地址
     */
    private String faddress;

    /**
     * 是否付清
     */
    private Integer ispay;

    /**
     * 是否贷款
     */
    private Integer isloans;

    /**
     * 估值
     */
    private Double fcost;

    /**
     * 建筑面积大小
     */
    private Double farea1;

    /**
     * 使用面积大小
     */
    private Double farea2;

    private static final long serialVersionUID = 1L;
}