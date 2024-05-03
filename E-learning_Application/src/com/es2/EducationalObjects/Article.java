package com.es2.EducationalObjects;

import com.es2.Exceptions.InvalidValueException;

import java.util.Date;
import java.util.List;

public class Article implements EducationalObjectInterface{
    private String title;
    private String description;
    private String content;
    private String author;
    private Date publishDate;
    private String category;
    private List<String> tags;
    private int evaluation;
    private List<String> comments;

    public Article() { }

    @Override
    public void setTitle(String _title) {
        this.title = _title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(String _description) { this.description = _description; }

    @Override
    public String getDescription() { return description; }

    public void setContent(String _content) { this.content = _content; }

    public String getContent() { return content; }

    public void setAuthor(String _author) { this.author = _author; }

    public String getAuthor() { return author; }

    public void setPublishDate(Date _publishDate) { this.publishDate = _publishDate; }

    public Date getPublishDate() { return publishDate; }

    public void setCategory(String _category) { this.category = _category; }

    public String getCategory() {
        return category;
    }

    public void setComments(List<String> _comments) { this.comments = _comments; }

    public List<String> getComments() { return comments; }

    public void setEvaluation(Integer _evaluation) throws InvalidValueException {
        if(_evaluation <= 0){
            throw new InvalidValueException("The evaluation value must be positive!");
        }

        this.evaluation = _evaluation;
    }

    public Integer getEvaluation() {
        return evaluation;
    }
    public void setTags(List<String> _tags) { this.tags = _tags; }

    public List<String> getTags() { return tags; }
}