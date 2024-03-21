package com.es2.memento;

import java.util.ArrayList;

public class Server {
    private ArrayList<String> students = new ArrayList<>();
    private Memento state;
    public Server() { }

    public void addStudent(String studentName) throws ExistingStudentException {
        for(String student : students){
            if(student.equals(studentName)) {
                throw new ExistingStudentException("A student with the provided name already exists!");
            }
        }
        students.add(studentName);
    }

    public Memento backup() {
        return state;
    }

    public void restore(Memento state){
        students.clear();
        students.addAll(state.getState());
    }

    public ArrayList<String> getStudentNames(){
        return students;
    }
}
