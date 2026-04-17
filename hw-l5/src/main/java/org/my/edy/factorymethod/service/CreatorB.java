package org.my.edy.factorymethod.service;

import org.my.edy.factorymethod.model.Product;
import org.my.edy.factorymethod.model.ProductB;

public class CreatorB extends Creator {
    @Override
    public void someOperation() {
        IO.println("CreatorB someOperation");
    }

    @Override
    public Product createProduct() {
        IO.println("CreatorB create ProductB");
        return new ProductB();
    }
}
