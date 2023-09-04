package com.healthy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TDataDate)实体类
 *
 * @author makejava
 * @since 2023-05-01 14:10:26
 */
public class DataDate implements Serializable {
    private static final long serialVersionUID = 205863754141168951L;
    
    private Integer id;
    /**
     * 睡觉时间
     */
    private Date sleeptime;
    /**
     * 睡醒时间
     */
    private Date waketime;
    /**
     * 早餐
     */
    private String breakfast;
    /**
     * 午餐
     */
    private String lunch;
    /**
     * 晚餐
     */
    private String dinner;
    /**
     * 其他
     */
    private String other;

    private Date creatTime;

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSleeptime() {
        return sleeptime;
    }

    public void setSleeptime(Date sleeptime) {
        this.sleeptime = sleeptime;
    }

    public Date getWaketime() {
        return waketime;
    }

    public void setWaketime(Date waketime) {
        this.waketime = waketime;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

}

