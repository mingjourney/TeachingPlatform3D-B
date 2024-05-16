package com.gugu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClassroomDTO {
    private Integer id;
    private String name;
    private Integer teacherId;
    private String password;
    private Integer rows;
    private Integer columns;
    private Integer vacancyCount;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date endTime;
    private Integer capacity;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVacancyCount() {
        return vacancyCount;
    }

    public void setVacancyCount(Integer vacancyCount) {
        this.vacancyCount = vacancyCount;
    }
}
