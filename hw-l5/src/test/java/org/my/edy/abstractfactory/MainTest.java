package org.my.edy.abstractfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.my.edy.abstractfactory.model.ProductA;
import org.my.edy.abstractfactory.model.ProductB;
import org.my.edy.abstractfactory.model.concreteA.ProductAVar1;
import org.my.edy.abstractfactory.model.concreteA.ProductAVar2;
import org.my.edy.abstractfactory.model.concreteB.ProductBVar1;
import org.my.edy.abstractfactory.model.concreteB.ProductBVar2;
import org.my.edy.abstractfactory.service.AbstractFactory;
import org.my.edy.abstractfactory.service.factory.FactoryVar1;
import org.my.edy.abstractfactory.service.factory.FactoryVar2;

class MainTest {
    static AbstractFactory abstractFactoryVar1;
    static AbstractFactory abstractFactoryVar2;

    @BeforeAll
    static void setUp() {
        abstractFactoryVar1 = new FactoryVar1();
        abstractFactoryVar2 = new FactoryVar2();
    }

    @Test
    public void createVar1ProductA() {
        ProductA productA = abstractFactoryVar1.createProductA();

        Assertions.assertNotNull(productA);
        Assertions.assertEquals(ProductAVar1.class, productA.getClass());
    }

    @Test
    public void createVar1ProductB() {
        ProductB productB = abstractFactoryVar1.createProductB();

        Assertions.assertNotNull(productB);
        Assertions.assertEquals(ProductBVar1.class, productB.getClass());
    }

    @Test
    public void createVar2ProductA() {
        ProductA productA = abstractFactoryVar2.createProductA();

        Assertions.assertNotNull(productA);
        Assertions.assertEquals(ProductAVar2.class, productA.getClass());
    }

    @Test
    public void createVar2ProductB() {
        ProductB productB = abstractFactoryVar2.createProductB();

        Assertions.assertNotNull(productB);
        Assertions.assertEquals(ProductBVar2.class, productB.getClass());
    }

}