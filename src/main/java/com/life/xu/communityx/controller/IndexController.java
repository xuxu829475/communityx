package com.life.xu.communityx.controller;

import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: communityx
 * @description: index
 * @author: Mr.Xu
 * @create: 2019-07-30 21:39
 **/
@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest request, HttpSession session){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if("token".equals(cookie.getName())){
                String token = cookie.getValue();
                User user = userService.findByToken(token);
                if (user != null){
                    session.setAttribute("user",user);
                    break;
                }
            }
        }
        return "index";
    }
}
