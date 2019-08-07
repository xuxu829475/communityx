package com.life.xu.communityx.service;

import com.life.xu.communityx.model.Question;

/**
 * @program: communityx
 * @description: 问题接口
 * @author: Mr.Xu
 * @create: 2019-08-07 17:43
 **/
public interface QuestionService {
    void createOrUpdate(Question question);
}
