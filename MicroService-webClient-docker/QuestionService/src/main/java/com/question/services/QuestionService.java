package com.question.services;

import com.question.entities.Question;

import java.util.List;


public interface QuestionService {

    public Question add(Question question);

    public List<Question> getAll();

    public Question getById(Long id);
    public Question update(Question question, Long id);

    public void removeAll();

    public List<Question> getByQuizId(Long quizId);
}
