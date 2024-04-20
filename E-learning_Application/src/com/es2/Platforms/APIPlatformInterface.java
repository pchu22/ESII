package com.es2.Platforms;

import com.es2.EducationalObjects.EducationalObjectInterface;

public interface APIPlatformInterface {
    EducationalObjectInterface getContent(String contentId);

    String setContent(EducationalObjectInterface content);
}
