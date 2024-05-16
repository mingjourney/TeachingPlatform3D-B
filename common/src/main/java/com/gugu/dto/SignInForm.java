package com.gugu.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gugu
 * @create 2023-04-24 9:58
 * @purpose
 */
@Data
public class SignInForm implements Serializable {
    private static final long serialVersionUID = 646641919476013994L;
    private Integer id;
    /**
     * 登录名a
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 当前身高 单位：厘米cm
     */
    private Double height;
    /**
     * 当前体重 单位: 千克
     */
    private Double weight;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别 男/女
     */
    private String sex;
    /**
     * 职业
     */
    private String profession;

    private String hobby;

    private String role;
}
