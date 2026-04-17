package org.my.edy.factorymethod.service;

import org.my.edy.factorymethod.model.Product;
import org.my.edy.factorymethod.model.ProductA;

public class CreatorA extends Creator {
    @Override
    public void someOperation() {
        IO.println("CreatorA someOperation");
    }

    @Override
    public Product createProduct() {
        IO.println("CreatorA create ProductA");
        return new ProductA();
    }
}
