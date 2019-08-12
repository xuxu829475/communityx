package com.life.xu.communityx.service;

import com.life.xu.communityx.vo.PaginationVO;
import com.life.xu.communityx.vo.QuestionVO;

import java.util.List;

/**
 * @program: communityx
 * @description: 问题接口
 * @author: Mr.Xu
 * @create: 2019-08-07 17:43
 **/
public interface QuestionService {
    void createOrUpdate(QuestionVO question);

    List<QuestionVO> list();

    PaginationVO<QuestionVO> page(Integer page, Integer pageSize);
}
