package org.my.edy.factorymethod.service;

import org.junit.jupiter.api.Test;
import org.my.edy.factorymethod.model.Product;
import org.my.edy.factorymethod.model.ProductB;

import static org.junit.jupiter.api.Assertions.*;

class CreatorBTest {

    @Test
    void createProductB() {
        Creator creator = new CreatorB();
        Product product = creator.createProduct();

        assertNotNull(product);
        assertEquals(ProductB.class, product.getClass());
    }

}