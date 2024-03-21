package com.es2.memento;

import java.util.HashMap;

public class BackupService {
    private Server server;
    private HashMap<Integer, Memento> snapshots = new HashMap<>();
    private int counter = 0;

    public BackupService(Server server){
        this.server = server;
    }

    public void takeSnapshot(){
        snapshots.put(counter, new Memento(server.getStudentNames()));
        counter++;
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
        if(!snapshots.containsKey(snapshotNumber)){
            throw new NotExistingSnapshotException("There are no snapshots with the provided ID!");
        }
        server.restore(snapshots.get(snapshotNumber));
    }
}
