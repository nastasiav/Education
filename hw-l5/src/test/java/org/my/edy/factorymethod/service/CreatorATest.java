package org.my.edy.factorymethod.service;

import org.junit.jupiter.api.Test;
import org.my.edy.factorymethod.model.Product;
import org.my.edy.factorymethod.model.ProductA;

import static org.junit.jupiter.api.Assertions.*;

class CreatorATest {

    @Test
    void createProductB() {
        Creator creator = new CreatorA();
        Product product = creator.createProduct();

        assertNotNull(product);
        assertEquals(ProductA.class, product.getClass());
    }
}