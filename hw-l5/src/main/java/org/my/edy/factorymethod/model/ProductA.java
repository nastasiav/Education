package org.my.edy.factorymethod.model;

public class ProductA implements Product {
    @Override
    public void getInfo() {
        IO.println("ProductA getInfo method.");
    }
}
