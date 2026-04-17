package org.my.edy.prototype;

public class Main {
    static void main() {
        ConcreteA concreteA = new ConcreteA();
        concreteA.setId(1);
        concreteA.setName("Name");

        ConcreteA clone = concreteA.clone();

        IO.println(clone);
    }
}
