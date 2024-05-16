package com.gugu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 运动记录(TSportitem)实体类
 *
 * @author makejava
 * @since 2023-04-23 21:04:12
 */
public class SportItem implements Serializable {
    private static final long serialVersionUID = -22674674988102768L;
    /**
     * 运动项id
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 运动类型 关联到sporttype表
     */
    private Integer standardType;
    /**
     * 运动持续时间 单位分钟
     */
    private Integer sporttime;
    /**
     * 消耗卡路里单位：千卡
     */
    private Object calorie;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public Integer getSporttime() {
        return sporttime;
    }

    public void setSporttime(Integer sporttime) {
        this.sporttime = sporttime;
    }

    public Object getCalorie() {
        return calorie;
    }

    public void setCalorie(Object calorie) {
        this.calorie = calorie;
    }

}

