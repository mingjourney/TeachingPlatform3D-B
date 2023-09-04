package com.healthy.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BrowsingHistoryDTO {
    private Integer id;
    private Integer userId;
    private Integer essayId;
    private LocalDateTime viewedAt;

    public BrowsingHistoryDTO() {
    }

    public BrowsingHistoryDTO(Integer id, Integer userId, Integer essayId, LocalDateTime viewedAt) {
        this.id = id;
        this.userId = userId;
        this.essayId = essayId;
        this.viewedAt = viewedAt;
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

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public LocalDateTime getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(LocalDateTime viewedAt) {
        this.viewedAt = viewedAt;
    }
}
