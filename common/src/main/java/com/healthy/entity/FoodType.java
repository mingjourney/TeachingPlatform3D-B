package com.healthy.entity;

import java.io.Serializable;

/**
 * 食物字典(TFoodtype)实体类
 *
 * @author makejava
 * @since 2023-04-23 21:04:12
 */
public class FoodType implements Serializable {
    private static final long serialVersionUID = -66520624474567236L;
    /**
     * 食物编号
     */
    private Integer id;
    /**
     * 食物名称
     */
    private String foodName;
    /**
     * 卡路里 每千克
     */
    private Object calorie;
    /**
     * 其他效果
     */
    private String other;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Object getCalorie() {
        return calorie;
    }

    public void setCalorie(Object calorie) {
        this.calorie = calorie;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

}

