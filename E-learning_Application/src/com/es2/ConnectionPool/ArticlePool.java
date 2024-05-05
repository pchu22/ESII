package com.es2.ConnectionPool;

import com.es2.EducationalObjects.Article;
import com.es2.Exceptions.ObjectNotFoundException;
import com.es2.Exceptions.PoolExhaustedException;

import java.util.ArrayList;

public class ArticlePool extends ObjectPool<Article> {
    static ArticlePool instance = null;
    int poolSize;
    ArrayList<Article> inUse = new ArrayList<>();
    ArrayList<Article> isAvailable = new ArrayList<>();

    private ArticlePool(){
        super(100);
    }

    public static ArticlePool getInstance(){
        if(instance == null){
            instance = new ArticlePool();
        }

        return instance;
    }

    @Override
    public synchronized Article acquire() throws PoolExhaustedException {
        if (inUse.size() >= poolSize) {
            throw new PoolExhaustedException("The object pool has no empty spaces!");
        }

        Article article;
        if (isAvailable.isEmpty()) {
            article = new Article();
        } else {
            article = isAvailable.remove(0);
        }

        inUse.add(article);
        return article;
    }

    @Override
    public synchronized void release(Article article) throws ObjectNotFoundException {
        if (!inUse.contains(article)){
            throw new ObjectNotFoundException("No object pool was found...");
        }

        isAvailable.add(article);
        inUse.remove(article);
    }
}