package com.life.xu.communityx.dao;

import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.QuestionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionDao {
    int countByExample(QuestionQuery example);

    int deleteByExample(QuestionQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExampleWithBLOBs(QuestionQuery example);

    List<Question> selectByExample(QuestionQuery example);

    Question selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionQuery example);

    int updateByExampleWithBLOBs(@Param("record") Question record, @Param("example") QuestionQuery example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionQuery example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKeyWithBLOBs(Question record);

    int updateByPrimaryKey(Question record);
}