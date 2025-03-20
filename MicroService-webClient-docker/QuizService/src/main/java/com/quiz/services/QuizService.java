package com.quiz.services;

import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {
    public Quiz add(Quiz quiz);

    public List<Quiz> getAll();

    public Quiz get(Long id);

    public void removeAll();

}
