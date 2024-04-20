package com.es2.EducationalObjects;

import com.es2.Exceptions.InvalidValueException;

import java.util.List;

public class Quiz implements EducationalObjectInterface {
    private String title;
    private String description;
    private List<String> questions;
    private List<String> answers;
    private int difficultyLevel;
    private int timeout;
    private String category;
    private int maxScore;
    private List<String> feedback;
    private int averageResponseTime;

    protected Quiz() { }

    @Override
    public void setTitle(String _title) {
        this.title = _title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(String _description) {
        this.description = _description;
    }

    @Override
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
}
