package com.uniware.controller;

import com.uniware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 10:47
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public List user(){
        return userService.users();
    }

}
