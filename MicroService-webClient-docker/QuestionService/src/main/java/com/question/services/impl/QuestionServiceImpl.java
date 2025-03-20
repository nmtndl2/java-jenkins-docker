package com.question.services.impl;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found!!"));
    }

    @Override
    public Question update(Question question, Long id) {
        question.setId(id);
        return questionRepository.save(question);
    }

    @Override
    public void removeAll() {
        questionRepository.deleteAll();
    }


    @Override
    public List<Question> getByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
