package com.es2.memento;

import java.util.ArrayList;

public class Memento {
    ArrayList<String> students = new ArrayList<>();
    public Memento(ArrayList<String> studentNames) {
        this.students.addAll(studentNames);
    }

    public ArrayList<String> getState() {
        return students;
    }
}
