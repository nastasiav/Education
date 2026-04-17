package org.my.edy.builder;

public class Director {

    public void createProduct(MyBuilder builder) {
        builder.reset();
        builder.buildStepA("Product");
        builder.buildStepB(100);
        builder.buildStepC(1L);
    }

    public void createBook(MyBuilder builder) {
        builder.reset();
        builder.buildStepA("Book");
        builder.buildStepB(200);
        builder.buildStepC(2L);
    }
}
