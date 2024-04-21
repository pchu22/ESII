package com.es2.LearningStructure;

import java.util.ArrayList;

public class SubGroup extends Group{
    private final ArrayList<Group> subGroups = new ArrayList<>();

    public SubGroup(String name) {
        super(name);
    }

    public void addChild(Group child){
        subGroups.add(child);
    }

    public void removeChild(Group child){
        subGroups.remove(child);
    }

    public void showContent(){
        System.out.println(getName());

        for (Group subGroup : subGroups){
            subGroup.showContent();
        }
    }
}
