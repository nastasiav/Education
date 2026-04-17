package org.my.edy.abstractfactory.service.factory;

import org.my.edy.abstractfactory.model.ProductA;
import org.my.edy.abstractfactory.model.ProductB;
import org.my.edy.abstractfactory.model.concreteA.ProductAVar2;
import org.my.edy.abstractfactory.model.concreteB.ProductBVar2;
import org.my.edy.abstractfactory.service.AbstractFactory;

public class FactoryVar2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductAVar2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductBVar2();
    }
}
