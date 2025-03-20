package com.question.controller;

import com.question.entities.Question;
import com.question.services.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

//PostMappin
    @PostMapping
    public Question  add(@RequestBody Question question) {
        questionService.add(question);
        System.out.println("Add Question successfully\n");
        return question;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }


    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    @PutMapping("/{id}")
    public Question update(@RequestBody Question question ,@PathVariable Long id) {
        return questionService.update(question, id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getByQuizId(@PathVariable Long quizId) {
        return questionService.getByQuizId(quizId);
    }

    @DeleteMapping
    public void removeAll() {
        questionService.removeAll();
    }
}
