package com.life.xu.communityx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.life.xu.communityx.Converter.QuestionConverter;
import com.life.xu.communityx.dao.QuestionDao;
import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.QuestionQuery;
import com.life.xu.communityx.model.User;
import com.life.xu.communityx.service.QuestionService;
import com.life.xu.communityx.service.UserService;
import com.life.xu.communityx.vo.PaginationVO;
import com.life.xu.communityx.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    QuestionConverter questionConverter;

    @Override
    public void createOrUpdate(QuestionVO questionVO) {
        Question question = new Question();
        BeanUtils.copyProperties(questionVO,question);
        if(question.getId() == null){
            question.setCommentCount(0);
            question.setLikeCount(0);
            question.setViewCount(0);
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(System.currentTimeMillis());
            questionDao.insertSelective(question);
        }else {
           // Question dbQuestion = questionDao.selectByPrimaryKey(question.getId());
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionQuery example = new QuestionQuery();
            example.createCriteria()
                    .andIdEqualTo(question.getId());
            int updated = questionDao.updateByExampleSelective(updateQuestion, example);
        }

    }

    @Override
    public List<QuestionVO> list() {
        QuestionQuery questionQuery = new QuestionQuery();
        List<Question> questions = questionDao.selectByExampleWithBLOBs(questionQuery);
        List<QuestionVO> questionVOList = questionConverter.question2QuestionVoConverter(questions);
        return questionVOList;
    }

    @Override
    public PaginationVO<QuestionVO> page(QuestionQuery questionQuery, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Question> questionList = questionDao.selectByExampleWithBLOBs(questionQuery);
        PageInfo<Question> pageInfo = new PageInfo<>(questionList);
        PaginationVO<QuestionVO> paginationVO = new PaginationVO<>();
        List<QuestionVO> questionVOList = questionConverter.question2QuestionVoConverter(questionList);
        paginationVO.setData(questionVOList);
        paginationVO.setPagination((int) pageInfo.getTotal(),page,pageSize);
        return paginationVO;
    }

    @Override
    public QuestionVO findById(Long id) {
        Question question = questionDao.selectByPrimaryKey(id);
        return questionConverter.question2QuestionVoConverter(question);
    }


}
