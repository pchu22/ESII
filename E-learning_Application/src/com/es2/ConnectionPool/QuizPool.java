package com.es2.ConnectionPool;

import com.es2.EducationalObjects.Quiz;
import com.es2.Exceptions.ObjectNotFoundException;
import com.es2.Exceptions.PoolExhaustedException;

import java.util.ArrayList;

public class QuizPool extends ObjectPool<Quiz> {
    static QuizPool instance = null;
    int poolSize;
    ArrayList<Quiz> inUse = new ArrayList<>();
    ArrayList<Quiz> isAvailable = new ArrayList<>();

    private QuizPool() {
        super(100);
    }

    public static QuizPool getInstance() {
        if (instance == null) {
            instance = new QuizPool();
        }

        return instance;
    }

    @Override
    public synchronized Quiz acquire() throws PoolExhaustedException {
        if (inUse.size() >= poolSize) {
            throw new PoolExhaustedException("The object pool has no empty spaces!");
        }

        Quiz quiz;
        if (isAvailable.isEmpty()) {
            quiz = new Quiz();
        } else {
            quiz = isAvailable.remove(0);
        }

        inUse.add(quiz);
        return quiz;
    }

    @Override
    public synchronized void release(Quiz quiz) throws ObjectNotFoundException {
        if (!inUse.contains(quiz)) {
            throw new ObjectNotFoundException("No object pool was found...");
        }

        isAvailable.add(quiz);
        inUse.remove(quiz);
    }
}