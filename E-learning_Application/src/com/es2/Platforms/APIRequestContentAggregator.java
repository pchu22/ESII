package com.es2.Platforms;

import com.es2.EducationalObjects.EducationalObjectInterface;
import com.es2.Exceptions.PlatformNotFoundException;

public class APIRequestContentAggregator extends APIRequest{
    public APIRequestContentAggregator(){ }

    public EducationalObjectInterface getContent(String platformId, String contentId) throws PlatformNotFoundException {
        APIPlatformInterface platform = platforms.get(platformId);

        if(platform == null){
            throw new PlatformNotFoundException("A platform with the given ID wasn't found or doesn't exist!");
        }

        return platform.getContent(contentId);
    }
}
