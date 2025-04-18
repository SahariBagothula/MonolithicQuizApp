package com.competition.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.competition.quizapp.dao.QuestionDao;
import com.competition.quizapp.entities.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
       try{
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
       }catch(Exception e){
            e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> createQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.getByCategory(category), HttpStatus.OK);
           }catch(Exception e){
                e.printStackTrace();
           }
           return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
       
    }

}
