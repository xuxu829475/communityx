package com.life.xu.communityx.service.impl;

import com.life.xu.communityx.Converter.QuestionConverter;
import com.life.xu.communityx.dao.QuestionDao;
import com.life.xu.communityx.model.Question;
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
            questionDao.insert(question);
        }else {
            question.setGmtModified(System.currentTimeMillis());
            questionDao.update(question);
        }

    }

    @Override
    public List<QuestionVO> list() {
        List<Question> questions = questionDao.findAll();
        List<QuestionVO> questionVOList = questionConverter.question2QuestionVoConverter(questions);
        return questionVOList;
    }

    @Override
    public PaginationVO<QuestionVO> page(Map<String,Object> parMap, Integer page, Integer pageSize) {
        Integer offPage = pageSize * (page - 1);
        Integer totalCount = questionDao.findCount(parMap);
        Integer totalPage;
        if(totalCount % pageSize == 0){
            totalPage = totalCount / pageSize;
        }else{
            totalPage = totalCount / pageSize + 1;
        }
        List<Question> questions = questionDao.findPage(parMap,offPage,pageSize);
        PaginationVO<QuestionVO> paginationVO = new PaginationVO<>();
        List<QuestionVO> questionVOList = questionConverter.question2QuestionVoConverter(questions);
        paginationVO.setData(questionVOList);
        paginationVO.setPagination(totalPage,page);
        return paginationVO;
    }

    @Override
    public QuestionVO findById(Long id) {
        Question question = questionDao.findById(id);
        return questionConverter.question2QuestionVoConverter(question);
    }


}
