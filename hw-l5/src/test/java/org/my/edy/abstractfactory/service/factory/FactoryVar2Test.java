package org.my.edy.abstractfactory.service.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.my.edy.abstractfactory.model.ProductA;
import org.my.edy.abstractfactory.model.ProductB;
import org.my.edy.abstractfactory.model.concreteA.ProductAVar2;
import org.my.edy.abstractfactory.model.concreteB.ProductBVar2;
import org.my.edy.abstractfactory.service.AbstractFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FactoryVar2Test {
    static AbstractFactory factory;

    @BeforeAll
    static void setUp() {
        factory = new FactoryVar2();
    }

    @Test
    void createProductA() {
        ProductA product = factory.createProductA();

        assertNotNull(product);
        assertEquals(ProductAVar2.class, product.getClass());
    }

    @Test
    void createProductB() {
        ProductB product = factory.createProductB();

        assertNotNull(product);
        assertEquals(ProductBVar2.class, product.getClass());
    }
}