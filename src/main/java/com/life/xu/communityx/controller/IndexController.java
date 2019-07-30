package com.life.xu.communityx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: communityx
 * @description: index
 * @author: Mr.Xu
 * @create: 2019-07-30 21:39
 **/
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
