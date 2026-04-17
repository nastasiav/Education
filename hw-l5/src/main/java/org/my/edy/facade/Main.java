package org.my.edy.facade;

public class Main {
    static void main() {
        SystemOne systemOne = new SystemOne();
        SystemTwo systemTwo = new SystemTwo();
        SystemThree systemThree = new SystemThree();

        Facade facade = new Facade(systemOne, systemTwo, systemThree);

        IO.println(facade.fullBusinessLogic(3));
        IO.println(facade.fullBusinessLogic(-3));
    }
}
