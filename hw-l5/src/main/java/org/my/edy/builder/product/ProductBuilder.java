package org.my.edy.builder.product;

import org.my.edy.builder.MyBuilder;

public class ProductBuilder implements MyBuilder {
    private Product product;

    @Override
    public void reset() {
        this.product = new Product();
    }

    @Override
    public void buildStepA(String name) {
        this.product.setName(name);
    }

    @Override
    public void buildStepB(int cost) {
        this.product.setCost(cost);
    }

    @Override
    public void buildStepC(long id) {
        this.product.setId(id);
    }

    public Product build() {
        return this.product;
    }
}
