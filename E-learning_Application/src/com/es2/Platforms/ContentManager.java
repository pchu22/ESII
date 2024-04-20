package com.es2.Platforms;

import com.es2.EducationalObjects.EducationalObjectInterface;

import java.util.LinkedHashMap;
import java.util.UUID;

public class ContentManager implements APIPlatformInterface{
    protected LinkedHashMap<String, EducationalObjectInterface> content = new LinkedHashMap<>();

    @Override
    public EducationalObjectInterface getContent(String contentId) {
        if (contentId.equals("0")) {
            throw new IllegalArgumentException("The content with the ID <0> doesn't exist!");
        }

        return content.get(contentId);
    }

    @Override
    public String setContent(EducationalObjectInterface _content) {
        String contentID = UUID.randomUUID().toString();
        content.put(contentID, _content);
        return contentID;
    }
}
