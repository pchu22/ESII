package com.es2.LearningStructure;

import java.util.ArrayList;
import java.util.List;

public class Group implements Component {
    private String name;
    private List<Component> components = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addComponents(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Group Name: " + name);
        for (Component component : components) {
            System.out.print("  ");
            component.display();
        }
    }
}
