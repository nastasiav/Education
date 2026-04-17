package org.my.edy.facade;

public class SystemOne {
    public boolean checkAvailability(double cost) {
        IO.println("System: Checking availability");
        return cost > 5;
    }
}
