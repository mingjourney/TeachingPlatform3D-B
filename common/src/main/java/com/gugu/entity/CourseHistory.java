package com.gugu.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CourseHistory {
    private int id; // 记录ID
    private int userId; // 用户ID
    private int courseId; // 课程ID
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date endTime;
    private int durationMinutes; // 听课时长（分钟）

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
