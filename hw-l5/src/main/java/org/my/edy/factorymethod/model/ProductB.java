package org.my.edy.factorymethod.model;

public class ProductB implements Product {
    @Override
    public void getInfo() {
        IO.println("ProductB getInfo method.");
    }
}
