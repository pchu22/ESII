package com.es2.Platforms;

import com.es2.EducationalObjects.EducationalObjectInterface;

public class APIDesktop implements APIPlatformInterface {
    private final ContentManager contentManager = new ContentManager();

    public APIDesktop(){ }

    @Override
    public EducationalObjectInterface getContent(String contentId) {
        return contentManager.getContent(contentId);
    }

    @Override
    public String setContent(EducationalObjectInterface content) {
        return contentManager.setContent(content);
    }
}
