package com.healthy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TTarget)实体类
 *
 * @author makejava
 * @since 2023-04-23 21:04:12
 */
public class Target implements Serializable {
    private static final long serialVersionUID = -64479332408732742L;
    /**
     * id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 目标
     */
    private String target;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 截止时间
     */
    private Date endTime;
    /**
     * 惩罚
     */
    private String punishment;
    /**
     * 是否完成
     */
    private Integer isFinish;

    private String reward;

    private Integer targetType;

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

}

