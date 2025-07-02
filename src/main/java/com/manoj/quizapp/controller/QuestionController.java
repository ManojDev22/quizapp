package com.manoj.quizapp.controller;



import com.manoj.quizapp.Question;
import com.manoj.quizapp.service.QuestionService;
//import com.manoj.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController

{
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public List<Question> getCategoryQuestions1(@PathVariable("cat") String category){
        return questionService.getCategoryQuestions(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
         return questionService.addQuestion(question);
    }

    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Question question){

            return questionService.deleteQuestion(question);
    }

    @PutMapping("edit")
    public ResponseEntity<String> editQuestion(@RequestBody Question question){
        return questionService.editQuestion(question);
    }

}
