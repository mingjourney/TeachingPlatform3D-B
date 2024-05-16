package com.gugu.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_date_plan
 * @author 
 */
@Data
public class DatePlan implements Serializable {
    private Integer id;

    private Integer userid;

    /**
     * 原因
     */
    private String reason;

    /**
     * 标题
     */
    private String slogan;

    /**
     * 计划
     */
    private String timeSlots;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}