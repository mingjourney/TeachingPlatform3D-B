package com.gugu.common;

import com.gugu.dto.UserDTO;

/**
 * @author Gugu
 * @create 2023-04-24 10:09
 * @purpose 用户暂存
 */
public class UserHolder {

    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();

    public static void saveUser(UserDTO user){
        tl.set(user);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
