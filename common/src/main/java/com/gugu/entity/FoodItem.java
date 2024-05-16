package com.gugu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 食物记录(TFooditem)实体类
 *
 * @author makejava
 * @since 2023-04-23 21:04:10
 */
public class FoodItem implements Serializable {
    private static final long serialVersionUID = 954722099011440722L;
    /**
     * 记录id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 食物名称
     */
    private String food;
    /**
     * 卡路里
     */
    private Object calorie;
    /**
     * 标准类型 关联到食物标准表
     */
    private Integer standardType;


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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Object getCalorie() {
        return calorie;
    }

    public void setCalorie(Object calorie) {
        this.calorie = calorie;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

}

