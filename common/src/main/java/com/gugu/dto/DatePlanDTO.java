package com.gugu.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-05-03 14:45
 * @purpose
 */
@Data
public class DatePlanDTO {
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
    private List<PlanDateDetails> timeSlots;

    /**
     * 创建时间
     */
    private Date createTime;
}
