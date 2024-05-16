package com.gugu.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gugu
 * @create 2023-04-24 11:04
 * @purpose
 */
@Data
public class UserLoginForm implements Serializable {
    private static final long serialVersionUID = 646418919476013994L;
    /**
     * 用户id
     */
    private Integer id;
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

    private String password;

    private String role;
}
