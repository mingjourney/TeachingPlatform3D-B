package com.healthy.exception.myException;

/**
 * @author Gugu
 * @create 2023-04-24 10:19
 * @purpose
 */
public class NotLoginException extends RuntimeException{
    public NotLoginException(String msg) {
        super(msg);
    }
}
