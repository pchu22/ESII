package com.es2.LearningStructure;

import java.util.ArrayList;
import java.util.List;

public abstract class Group {
    private String name;
    private final List<Lesson> lessons = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public abstract void showContent();
}
