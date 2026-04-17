package org.my.edy.abstractfactory;

import org.my.edy.abstractfactory.model.ProductA;
import org.my.edy.abstractfactory.model.ProductB;
import org.my.edy.abstractfactory.service.AbstractFactory;
import org.my.edy.abstractfactory.service.factory.FactoryVar1;
import org.my.edy.abstractfactory.service.factory.FactoryVar2;

public class Main {
    static void main() {
        AbstractFactory factory;
        int x = Integer.parseInt(IO.readln());

        if (x == 1) {
            factory = new FactoryVar1();
        } else {
            factory = new FactoryVar2();
        }

        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();

        IO.println(productA);
        IO.println(productB);
    }
}
