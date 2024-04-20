package com.es2.EducationalObjects;

import com.es2.Exceptions.UndefinedEducationalObjectException;

public class FactoryEducationalObject {
    protected FactoryEducationalObject() { }

    public static EducationalObjectInterface makeEducationalObject(String type) throws UndefinedEducationalObjectException {
        if(type == null){
            throw new  IllegalArgumentException("The educational object type can't be null");
        } else if (type.equalsIgnoreCase("Article")) {
            return new Article();
        } else if (type.equalsIgnoreCase("Quiz")) {
            return new Quiz();
        } else if (type.equalsIgnoreCase("Video")) {
            return new Video();
        } else {
            throw new UndefinedEducationalObjectException("You cannot create that object type!\n Object Type: " + type);
        }
    }
}
