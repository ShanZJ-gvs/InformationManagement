package com.gvssimux.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 用户唯一标识
     */
    private String uid;

    /**
     * 身份证
     */
    private String uuid;

    /**
     * 姓名
     */
    private String uname;

    /**
     * 房产信息唯一标识
     */
    private String fid;

    /**
     * 通话信息唯一标识
     */
    private Integer tid;

    private static final long serialVersionUID = 1L;
}