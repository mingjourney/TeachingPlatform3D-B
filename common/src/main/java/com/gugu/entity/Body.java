package com.gugu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 身体情况趋势表(TBody)实体类
 *
 * @author makejava
 * @since 2023-04-23 21:04:10
 */
public class Body implements Serializable {
    private static final long serialVersionUID = 462080096888743668L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 身高 单位：厘米cm
     */
    private Integer height;
    /**
     * 体重 单位：千克kg
     */
    private Double weight;
    /**
     * 记录时间
     */
    private Date time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}

