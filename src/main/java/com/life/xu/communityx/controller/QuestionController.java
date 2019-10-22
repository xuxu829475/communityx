package com.life.xu.communityx.controller;

import com.life.xu.communityx.Converter.QuestionConverter;
import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.service.QuestionService;
import com.life.xu.communityx.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: communityx
 * @description: 问题详情
 * @author: Mr.Xu
 * @create: 2019-09-04 20:28
 **/
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionConverter questionConverter;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Long id , Model model){
        QuestionVO question = questionService.findById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", question);
        return "question";
    }
}
