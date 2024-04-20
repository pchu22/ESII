package com.es2.EducationalObjects;

import com.es2.Exceptions.InvalidValueException;

import java.util.List;

public class Video implements EducationalObjectInterface {
    private String title;
    private String description;
    private String URL;
    private int duration;
    private String language;
    private String quality;
    private List<String> comments;
    private List<String> tags;

    protected Video() { }

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

    public void setURL(String _url) { this.URL = _url; }

    public String getURL() { return URL; }

    public void setDuration(Integer _duration) throws InvalidValueException {
        if(_duration <= 0){
            throw new InvalidValueException("The duration value must be positive!");
        }

        this.duration = _duration; }

    public Integer getDuration() { return duration; }

    public void setLanguage(String _language) { this.language = _language; }

    public String getLanguage() { return language; }

    public void setQuality(String _quality) { this.quality = _quality; }

    public String getQuality() { return quality; }

    public void setComments(List<String> _comments) { this.comments = _comments; }

    public List<String> getComments() { return comments; }

    public void setTags(List<String> _tags) { this.tags = _tags; }

    public List<String> getTags() { return tags; }
}
