package com.es2.LearningStructure;

import java.util.ArrayList;
import java.util.List;

public class Course extends Group {
    private List<Group> groups = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();

    public Course(String name) {
        super(name);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public List<Group> getGroups() {
        return groups;
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

    @Override
    public void showContent() {
        System.out.println("Course: " + getName());

        if (!groups.isEmpty()) {
            System.out.println("Groups:");
            for (Group group : groups) {
                System.out.println("- " + group.getName());
                group.showContent();
            }
        }

        if (!lessons.isEmpty()) {
            System.out.println("Lessons:");
            for (Lesson lesson : lessons) {
                System.out.println("- " + lesson.getTitle());
            }
        }
    }

}
