package com.es2;

public class GlobalConfig {
    private static GlobalConfig instance;
    private String language;
    private String dateFormat;
    private String appName;
    private Float version;
    private String connectionString;
    private String path;
    private long maxFileSize;


    private GlobalConfig(){ }

    public static GlobalConfig getInstant(){
        if(instance == null){
            instance = new GlobalConfig();
        }

        return instance;
    }

    public void setLanguage(String _language){
        this.language = _language;
    }

    public void setDateFormat(String _dateFormat){
        this.dateFormat = _dateFormat;
    }

    public void setAppName(String _appName){
        this.appName = _appName;
    }
    public void setVersion (Float _version){
        this.version = _version;
    }

    public void setConnectionString(String _connectionString){
        this.connectionString = _connectionString;
    }

    public void setPath(String _path){
        this.path = _path;
    }

    public void setMaxFileSize(Long _maxFileSize) throws ConfigurationException {
        if(_maxFileSize <= 0){
            throw new ConfigurationException("Max File Size must be a positive value!");
        }

        this.maxFileSize = _maxFileSize;
    }

    public String getLanguage(){
        return language;
    }

    public String getDateFormat(){
        return dateFormat;
    }

    public String getAppName(){
        return appName;
    }

    public Float getVersion(){
        return version;
    }

    public String getConnectionString(){
        return connectionString;
    }

    public String getPath(){
        return path;
    }

    public Long getMaxFileSize(){ return maxFileSize; }
}
