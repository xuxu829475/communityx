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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.StringTokenizer;

/**
 * @program: communityx
 * @description: 发布
 * @author: Mr.Xu
 * @create: 2019-08-02 14:44
 **/
@Controller
public class PublishController {

    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        QuestionVO questionVO = questionService.findById(id);
        model.addAttribute("question", questionVO);
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping(value = "/publish")
    public String doPublish( QuestionVO questionVO,Model model) {

        if (StringUtils.isEmpty(questionVO.getTitle().trim())) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(questionVO.getDescription())) {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(questionVO.getTag())) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
        questionService.createOrUpdate(questionVO);
        return "redirect:/";
    }
}
