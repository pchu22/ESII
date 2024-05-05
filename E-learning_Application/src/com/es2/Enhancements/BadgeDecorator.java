package com.es2.Enhancements;

import com.es2.EducationalObjects.EducationalObjectInterface;
import com.es2.LearningStructure.Component;

public class BadgeDecorator<T extends Component & EducationalObjectInterface> implements Component, EducationalObjectInterface {
    private T decoratorObject;

    public BadgeDecorator(T decoratedObject) {
        this.decoratorObject = decoratedObject;
    }

    @Override
    public void display() {
        decoratorObject.display();
        System.out.println("Adding completion badge!");
    }
}
