package com.es2.singleton;

public class Registry {
    static Registry instance = null;
    String ConnectionString;
    String Path;

    public int x = 10;

    private Registry() {}

    public static Registry getInstance() {
        if(instance == null){
            instance = new Registry();
        }

        return instance;
    }

    public String getPath(){
        return Path;
    }

    public String getConnectionString(){ return ConnectionString; }

    public void setConnectionString(String connectionString){
        ConnectionString = connectionString;
    }

    public void setPath(String path){
        Path = path;
    }
}
