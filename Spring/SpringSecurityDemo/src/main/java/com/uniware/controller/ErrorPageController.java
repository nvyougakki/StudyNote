package com.uniware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ErrorPageController
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 14:23
 */
@Controller
public class ErrorPageController {

    @RequestMapping("/error/{errorCode}")
    public String erroePage(@PathVariable int errorCode){
        return "/" + errorCode;
    }

}
