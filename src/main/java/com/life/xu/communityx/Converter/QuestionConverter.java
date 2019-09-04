package com.life.xu.communityx.Converter;

import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.UserService;
import com.life.xu.communityx.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: communityx
 * @description: 问题VO转换器
 * @author: Mr.Xu
 * @create: 2019-09-04 20:37
 **/
@Component
public class QuestionConverter {

    @Autowired
    UserService userService;

    public QuestionVO question2QuestionVoConverter(Question question){
        QuestionVO questionVO = new QuestionVO();
        User user = userService.findById(question.getCreator());
        BeanUtils.copyProperties(question, questionVO);
        questionVO.setUser(user);
        return questionVO;
    }

    public List<QuestionVO> question2QuestionVoConverter(List<Question> questions) {
        List<QuestionVO> questionVOList = new ArrayList<>();
        QuestionVO questionVO;
        for (Question question : questions) {
            questionVO = question2QuestionVoConverter(question);
            questionVOList.add(questionVO);
        }
        return questionVOList;
    }
}
