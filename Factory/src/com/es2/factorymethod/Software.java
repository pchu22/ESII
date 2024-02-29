package com.es2.factorymethod;

public class Software implements Product{
    String Brand;

    protected Software(){ }

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
