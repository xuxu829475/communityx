package com.life.xu.communityx.dao;

import com.life.xu.communityx.model.Question;
import com.life.xu.communityx.model.QuestionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionExtDao {
    int incView(Question record);
}