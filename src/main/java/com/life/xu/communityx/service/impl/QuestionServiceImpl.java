package com.life.xu.communityx.service.impl;

import com.life.xu.communityx.dao.QuestionDao;
import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.QuestionService;
import com.life.xu.communityx.service.UserService;
import com.life.xu.communityx.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: communityx
 * @description: 问题接口实现类
 * @author: Mr.Xu
 * @create: 2019-08-07 17:46
 **/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;
    @Autowired
    UserService userService;

    @Override
    public void createOrUpdate(Question question) {
        questionDao.insert(question);
    }

    @Override
    public List<QuestionVO> list() {
        List<Question> questions = questionDao.findAll();
        List<QuestionVO> questionVOList = new ArrayList<>();
        QuestionVO questionVO;
        for (Question question : questions) {
            User user = userService.findById(question.getCreator());
            questionVO = new QuestionVO();
            BeanUtils.copyProperties(question,questionVO);
            questionVO.setUser(user);
            questionVOList.add(questionVO);
        }
        return questionVOList;
    }
}
