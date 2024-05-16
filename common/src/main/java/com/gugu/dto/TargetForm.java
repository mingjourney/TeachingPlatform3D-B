package com.gugu.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-05-01 14:14
 * @purpose
 */
@Data
public class TargetForm {
    private List<Goal> goals;
    private Date targetDate;
    private String reward;
    private String punishment;
}
