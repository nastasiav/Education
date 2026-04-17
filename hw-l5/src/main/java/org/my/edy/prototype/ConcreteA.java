package org.my.edy.prototype;

public class ConcreteA extends Prototype {
    public ConcreteA() {
    }

    public ConcreteA(Prototype source) {
        super(source);
    }

    @Override
    public ConcreteA clone() {
        return new ConcreteA(this);
    }

    @Override
    public String toString() {
        return "ConcreteA = " + super.toString();
    }
}
