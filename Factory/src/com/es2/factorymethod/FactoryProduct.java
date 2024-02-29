package com.es2.factorymethod;

public abstract class FactoryProduct {
    protected  FactoryProduct(){ }
    public static Product makeProduct(String type) throws UndefinedProductException {
        if(type == null){
            return null;
        } else if (type.equalsIgnoreCase("Computer")) {
            return new Computer();
        } else if (type.equalsIgnoreCase("Software")){
            return new Software();
        } else {
            throw new UndefinedProductException("You cannot crate " + type + " Products!");
        }
    }
}
