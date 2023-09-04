package com.healthy.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private Integer id;
    private Integer userId;
    private Integer essayId;
    private LocalDateTime timeAt;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

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

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public void setTimeAt() {
        this.timeAt = LocalDateTime.now();
    }

    public String getTimeAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timeAt.format(formatter);
    }
}
