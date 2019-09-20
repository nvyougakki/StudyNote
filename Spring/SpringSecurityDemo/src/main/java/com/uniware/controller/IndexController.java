package com.uniware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 13:39
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }

}
