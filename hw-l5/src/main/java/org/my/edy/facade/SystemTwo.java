package org.my.edy.facade;

public class SystemTwo {
    public double calculate(String count) {
        IO.println("SystemTwo: calculate");
        return count.length() * 2.0;
    }
}
