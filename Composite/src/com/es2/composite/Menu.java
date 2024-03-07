package com.es2.composite;

public abstract class Menu{
    public String Label;
    public Menu(){ }

    public String getLabel(){
        return Label;
    }

    public void setLabel(String label){
        Label = label;
    }

    public abstract void showOptions();
}
