package org.my.edy.builder;

public interface MyBuilder {
    void reset();
    void buildStepA(String name);
    void buildStepB(int cost);
    void buildStepC(long id);
}
