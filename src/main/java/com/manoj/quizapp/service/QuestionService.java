package com.manoj.quizapp.service;


import com.manoj.quizapp.Question;
import com.manoj.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public List<Question> getCategoryQuestions(String category) {

//        List<Question> res=questionDao.findAll();
//        List<Question> c1=new ArrayList<>();
//        System.out.println("manoj"+res);
//        for(Question a:res){
//            if(a.category.equals(category))c1.add(a);
//        }
//        return c1;
        return questionDao.findByCategory(category);
   }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "sucess";
    }

    public String deleteQuestion(Question question) {
        questionDao.delete(question);
        return "Deleted";
    }

    public ResponseEntity<String> editQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("Edited", HttpStatus.CREATED);
    }
}
