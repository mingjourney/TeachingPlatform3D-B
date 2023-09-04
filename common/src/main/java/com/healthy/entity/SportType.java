package com.healthy.entity;

import java.io.Serializable;

/**
 * 运动类型表
(TSporttype)实体类
 *
 * @author makejava
 * @since 2023-04-23 21:04:12
 */
public class SportType implements Serializable {
    private static final long serialVersionUID = -89285959053516733L;
    /**
     * 运动类型编号
     */
    private Integer id;
    /**
     * 运动名称
     */
    private String sportName;
    /**
     * 每分钟消耗卡路里
     */
    private Double calorie;
    /**
     * 其他信息
     */
    private String other;

    private String icon;

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

}

