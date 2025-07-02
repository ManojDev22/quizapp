package com.manoj.quizapp;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Value;

@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String questionTitle;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String  difficultyLevel;
    public String rightAnswer;
    public String category;

}
