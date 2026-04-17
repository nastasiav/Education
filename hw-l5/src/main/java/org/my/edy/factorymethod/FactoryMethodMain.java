package org.my.edy.factorymethod;

import org.my.edy.factorymethod.model.Product;
import org.my.edy.factorymethod.service.Creator;
import org.my.edy.factorymethod.service.CreatorA;
import org.my.edy.factorymethod.service.CreatorB;

public class FactoryMethodMain {
    static void main() {
        IO.println("FactoryMethodMain Begin");

        int x = Integer.parseInt(IO.readln());
        Creator creator;

        if (x == 0) {
            creator = new CreatorA();
        } else {
            creator = new CreatorB();
        }

        Product product = creator.createProduct();
        product.getInfo();

        IO.println("FactoryMethodMain End");
    }
}
