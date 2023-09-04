package com.healthy.dto;

import lombok.Data;

/**
 * @author Gugu
 * @create 2023-04-24 10:11
 * @purpose
 */
@Data
public class UserDTO {
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

    private String role;
}
