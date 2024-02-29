package com.es2.factorymethod;

public class Computer implements Product{
    String Brand;

    protected Computer(){ }

    @Override
    public void setBrand(String brand) {
        Brand = brand;
    }

    @Override
    public String getBrand() {
        System.out.println(Brand);
        return Brand;
    }
}
