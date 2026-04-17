package org.my.edy.factorymethod.service;

import org.my.edy.factorymethod.model.Product;

public abstract class Creator {
    public abstract void someOperation();
    public abstract Product createProduct();
}
