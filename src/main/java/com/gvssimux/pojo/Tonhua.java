package com.gvssimux.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tonhua
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tonhua implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 通话记录唯一标识
     */
    private Integer tid;

    /**
     * user唯一标识
     */
    private String uid;

    /**
     * 通话对象
     */
    private Integer tobject;

    /**
     * 通话开始时间
     */
    private Date ttime;

    /**
     * 通话结束时间
     */
    private Date ttime2;

    private static final long serialVersionUID = 1L;
}