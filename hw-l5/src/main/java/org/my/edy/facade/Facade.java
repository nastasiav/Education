package org.my.edy.facade;

public class Facade {
    SystemOne systemOne;
    SystemTwo systemTwo;
    SystemThree systemThree;

    public Facade(SystemOne system, SystemTwo systemTwo, SystemThree systemThree) {
        this.systemOne = system;
        this.systemTwo = systemTwo;
        this.systemThree = systemThree;
    }

    public boolean fullBusinessLogic(int x) {
        String res3 = systemThree.testing(x);
        double res2 = systemTwo.calculate(res3);
        return systemOne.checkAvailability(res2);
    }
}
