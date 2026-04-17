package org.my.edy.abstractfactory.service;

import org.my.edy.abstractfactory.model.ProductA;
import org.my.edy.abstractfactory.model.ProductB;

public interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}
