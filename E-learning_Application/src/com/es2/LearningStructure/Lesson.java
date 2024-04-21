package com.es2.LearningStructure;

import com.es2.EducationalObjects.EducationalObjectInterface;

import java.util.ArrayList;

public class Lesson {
    private String title;
    private String description;
    private long duration;
    private ArrayList<EducationalObjectInterface> resources = new ArrayList<>();
    private boolean isCompleted = false;

    public Lesson(String _title, String _description) {
        this.title = _title;
        this.description = _description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ArrayList<EducationalObjectInterface> getResources() {
        return resources;
    }

    public void addResource(EducationalObjectInterface _resource) {
        this.resources.add(_resource);
    }

    public long getDuration() {
        return duration;
    }

    public void setDurationMinutes(long _duration) {
        this.duration = _duration;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean _completed) {
        isCompleted = _completed;
    }
}
