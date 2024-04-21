package com.es2.ConnectionPool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnectionPool extends ObjectPool<HttpURLConnection>{
    private String urlString;
    public HTTPConnectionPool(String _url){
        this.urlString = _url;
    }

    @Override
    HttpURLConnection create() {
        try {
            URL url = new URL(urlString);
            return (HttpURLConnection) url.openConnection();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    boolean validate(HttpURLConnection object) {
        try{
            return (object.getResponseCode() < 400);
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    void dead(HttpURLConnection object) {
        object.disconnect();
    }

    public String getURL() {
        return urlString;
    }

    public void setURL(String URL) {
        this.urlString = URL;
    }
}
