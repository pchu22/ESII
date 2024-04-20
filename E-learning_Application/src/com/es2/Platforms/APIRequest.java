package com.es2.Platforms;

import com.es2.EducationalObjects.EducationalObjectInterface;
import com.es2.Exceptions.PlatformNotFoundException;

import java.util.HashMap;
import java.util.UUID;

public class APIRequest {
    protected HashMap<String, APIPlatformInterface> platforms = new HashMap<>();

    public APIRequest(){ }

    public String addPlatform(APIPlatformInterface platform){
        String platformID = UUID.randomUUID().toString();
        this.platforms.put(platformID, platform);
        return platformID;
    }

    public String setContent(String platformId, EducationalObjectInterface content) throws PlatformNotFoundException {
        APIPlatformInterface service = platforms.get(platformId);

        if(service == null){
            throw new PlatformNotFoundException("A platform with the given ID wasn't found or doesn't exist!");
        }

        return service.setContent(content);
    }

    public EducationalObjectInterface getContent(String platformId, String contentId) throws PlatformNotFoundException {
        APIPlatformInterface service = platforms.get(platformId);

        if(service == null){
            throw new PlatformNotFoundException("A platform with the given ID wasn't found or doesn't exist!");
        }

        return service.getContent(contentId);
    }
}
