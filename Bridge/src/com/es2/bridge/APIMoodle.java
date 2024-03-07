package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.Map;

public class APIMoodle implements APIServiceInterface{
    protected LinkedHashMap<String, String> content = new LinkedHashMap<>();
    int count = 0;

    public APIMoodle() { }

    public String getContent(String contentId){
        String result = "";

        if(!contentId.equals("0")){
            return content.get(contentId);
        }

        for(Map.Entry<String, String> entry: content.entrySet()){
            result = result.concat(entry.getValue());
        }

        return result;
    }

    public String setContent(String content){
        String contentID = "content ID " + count;
        this.content.put(contentID, content);
        count++;
        return contentID;
    }

}
