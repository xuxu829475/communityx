package com.life.xu.communityx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: communityx
 * @description: 发布
 * @author: Mr.Xu
 * @create: 2019-08-02 14:44
 **/
@Controller
public class publishController {

    @RequestMapping("publish")
    public String publish(){
        return "publish";
    }
}
