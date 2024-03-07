package com.es2.composite;

import java.util.ArrayList;

public class SubMenu extends Menu {
    private final ArrayList<Menu> subMenus = new ArrayList<Menu>();

    public SubMenu(){ }

    public void addChild(Menu child){
        subMenus.add(child);
    }

    public void removeChild(Menu child){
        subMenus.remove(child);
    }

    public void showOptions(){
        System.out.println(getLabel());

        for (Menu subMenu : subMenus){
            subMenu.showOptions();
        }
    }
}
