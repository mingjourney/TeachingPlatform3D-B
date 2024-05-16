package com.gugu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-05-01 15:10
 * @purpose
 */
@Data
public class DateDataForm {
    /**
     * 睡觉时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date sleepTime;
    /**
     * 睡醒时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date wakeTime;
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

    private List<SportItem> sports;
}
