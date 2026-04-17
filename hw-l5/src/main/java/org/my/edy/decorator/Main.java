package org.my.edy.decorator;

public class Main {
    static void main() {

        Component component = new ConcreteComponent();
        Component decorated = new CryptionDecorator(component);

        decorated.execute();
    }
}
