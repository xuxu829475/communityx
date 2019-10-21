package com.life.xu.communityx.controller;

import com.alibaba.druid.util.StringUtils;
import com.life.xu.communityx.model.QuestionQuery;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.QuestionService;
import com.life.xu.communityx.service.UserService;
import com.life.xu.communityx.vo.PaginationVO;
import com.life.xu.communityx.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @program: communityx
 * @description: 个人中心
 * @author: Mr.Xu
 * @create: 2019-08-20 10:42
 **/
@Controller
public class ProfileController {

    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action")String action,
                          @CookieValue(value = "token",required = false) String token,
                          Model model,
                          @RequestParam(name = "page",defaultValue = "1")Integer page,
                          @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize){

        if (StringUtils.isEmpty(token)) {
            model.addAttribute("error", "用户未登录");
            return "redirect:/";
        }

        if ("qestions".equals(action)) {
            model.addAttribute("section",action);
            model.addAttribute("sectionName","我的提问");
        }else if("repies".equals(action)){
            model.addAttribute("section",action);
            model.addAttribute("sectionName","最新提问");
        }
        User user = userService.findByToken(token);
        HashMap<String, Object> parMap = new HashMap<>(16);
        parMap.put("creator", user.getId());
        QuestionQuery questionQuery = new QuestionQuery();
        QuestionQuery.Criteria questionQueryCriteria = questionQuery.createCriteria();
        questionQueryCriteria.andCreatorEqualTo(user.getId());
        PaginationVO<QuestionVO> questionList = questionService.page(questionQuery,page,pageSize);
        model.addAttribute("pagination",questionList);
        return "profile";
    }
}
