package com.healthy.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BrowsingHistory {
    private Integer id;
    private Integer userId;
    private Integer essayId;
    private LocalDateTime timeAt;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

//    public LocalDateTime getViewedAt() {
//        return viewedAt;
//    }

    public void setTimeAt() {
        this.timeAt = LocalDateTime.now();
    }

    public String getTimeAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timeAt.format(formatter);
    }

}
