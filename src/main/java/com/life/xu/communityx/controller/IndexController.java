package com.life.xu.communityx.controller;

import com.alibaba.druid.util.StringUtils;
import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.QuestionService;
import com.life.xu.communityx.service.UserService;
import com.life.xu.communityx.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String index(@CookieValue(value = "token", required = false) String token, HttpSession session, Model model) {
        if (!StringUtils.isEmpty(token)){
            User user = userService.findByToken(token);
            if (user != null) {
                session.setAttribute("user", user);
            }
        }
        List<QuestionVO> questionList = questionService.list();
        model.addAttribute("questionList", questionList);
        return "index";
    }
}
