package com.es2.EducationalObjects;

import com.es2.Exceptions.InvalidValueException;
import com.es2.StateStorage.Caretaker;
import com.es2.StateStorage.Memento;

import java.util.*;

public class Quiz implements EducationalObjectInterface, Memento<Quiz> {
    private String title;
    private String description;
    private List<String> questions = new ArrayList<>();
    private List<String> answers  = new ArrayList<>();
    private int difficultyLevel;
    private int timeout;
    private String category;
    private int maxScore;
    private List<String> feedback = new ArrayList<>();
    private int averageResponseTime;
    private Caretaker<Quiz> caretaker = new Caretaker<>();

    public Quiz() { }

    public Quiz(Quiz other) {
        this.title = other.title;
        this.description = other.description;
        this.questions = other.questions;
        this.answers = other.answers;
        this.difficultyLevel = other.difficultyLevel;
        this.timeout = other.timeout;
        this.category = other.category;
        this.maxScore = other.maxScore;
        this.feedback = other.feedback;
        this.averageResponseTime = other.averageResponseTime;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public String getDescription() {
        return description;
    }

    public void setQuestions(List<String> _questions) { this.questions = _questions; }

    public List<String> getQuestions() {
        return questions;
    }

    public void setAnswers(List<String> _answers) { this.answers = _answers; }

    public List<String> getAnswers() {
        return answers;
    }

    public void setDifficultyLevel(Integer _difficultyLevel) {
        this.difficultyLevel = _difficultyLevel;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setTimeout(Integer _timeout) throws InvalidValueException {
        if(_timeout <= 0){
            throw new InvalidValueException("The timeout value must be positive!");
        }

        this.timeout = _timeout;
    }

    public Integer getTimeout() { return timeout; }

    public void setCategory(String _category) { this.category = _category; }

    public String getCategory() {
        return category;
    }

    public void setMaxScore(Integer _maxScore) throws InvalidValueException {
        if(_maxScore <= 0){
            throw new InvalidValueException("The max score value must be positive!");
        }

        this.maxScore = _maxScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setFeedback(List<String> _feedback) { this.feedback = _feedback; }

    public List<String> getFeedback() { return feedback; }

    public void setAverageResponseTime(Integer _averageResponseTime) throws InvalidValueException {
        if(_averageResponseTime <= 0){
            throw new InvalidValueException("The average response time value must be positive!");
        }

        this.averageResponseTime = _averageResponseTime;
    }

    public Integer getAverageResponseTime() {
        return averageResponseTime;
    }

    @Override
    public void display() {

    }

    @Override
    public Quiz getState() {
        return new Quiz(this);
    }

    public void saveState(String key) {
        caretaker.saveState(key, this.getState());
    }

    public void restoreState(String key) {
        Memento<Quiz> memento = caretaker.restoreState(key);
        if (memento != null) {
            Quiz restoredQuiz = memento.getState();

            this.title = restoredQuiz.getTitle();
            this.description = restoredQuiz.getDescription();
            this.questions = new ArrayList<>(restoredQuiz.getQuestions());
            this.answers = new ArrayList<>(restoredQuiz.getAnswers());
            this.difficultyLevel = restoredQuiz.getDifficultyLevel();
            this.timeout = restoredQuiz.getTimeout();
            this.category = restoredQuiz.getCategory();
            this.maxScore = restoredQuiz.getMaxScore();
            this.feedback = new ArrayList<>(restoredQuiz.getFeedback());
            this.averageResponseTime = restoredQuiz.getAverageResponseTime();
        }
    }
}