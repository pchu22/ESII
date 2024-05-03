package com.es2.LearningStructure;

import com.es2.EducationalObjects.EducationalObjectInterface;

import java.util.ArrayList;
import java.util.List;

public class Lesson implements Component {
    private String title;
    private String description;
    private long duration;
    private List<EducationalObjectInterface> resources = new ArrayList<>();
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

    public List<EducationalObjectInterface> getResources() {
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

    @Override
    public void display() {
        System.out.println("Lesson: " + title);
        System.out.println("Description: " + description);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Resources:");
        for (EducationalObjectInterface resource : resources) {
            System.out.println("- " + resource.getTitle());
        }
    }

}
