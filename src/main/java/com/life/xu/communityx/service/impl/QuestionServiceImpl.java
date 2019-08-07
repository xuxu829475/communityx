package com.life.xu.communityx.service.impl;

import com.life.xu.communityx.dao.QuestionDao;
import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void createOrUpdate(Question question) {
        questionDao.insert(question);
    }
}
