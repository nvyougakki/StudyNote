package com.uniware.exception;

/**
 * @ClassName UserNotFoundException
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/21 0:54
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
