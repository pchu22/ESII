package com.es2.ConnectionPool;

import com.es2.EducationalObjects.Video;
import com.es2.Exceptions.ObjectNotFoundException;
import com.es2.Exceptions.PoolExhaustedException;

import java.util.ArrayList;

public class VideoPool extends ObjectPool<Video> {
    static VideoPool instance = null;
    int poolSize;
    ArrayList<Video> inUse = new ArrayList<>();
    ArrayList<Video> isAvailable = new ArrayList<>();

    private VideoPool(){
        super(10);
    }

    public static VideoPool getInstance(){
        if(instance == null){
            instance = new VideoPool();
        }

        return instance;
    }

    @Override
    public synchronized Video acquire() throws PoolExhaustedException {
        if (inUse.size() >= poolSize) {
            throw new PoolExhaustedException("The object pool has no empty spaces!");
        }

        Video video;
        if (isAvailable.isEmpty()) {
            video = new Video();
        } else {
            video = isAvailable.remove(0);
        }

        inUse.add(video);
        return video;
    }

    @Override
    public synchronized void release(Video video) throws ObjectNotFoundException {
        if (!inUse.contains(video)){
            throw new ObjectNotFoundException("No object pool was found...");
        }

        isAvailable.add(video);
        inUse.remove(video);
    }
}