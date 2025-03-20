package com.quiz.services;

import com.quiz.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class QuestionClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/question/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/question/quiz/" + quizId)
                .retrieve()
                .bodyToFlux(Question.class)
                .collectList()
                .block();
    }
}
