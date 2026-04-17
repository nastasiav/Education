package org.my.edy.facade;

public class SystemThree {
    public String testing(int x) {
        IO.println("SystemTwo: testing");
        if (x > 0)
            return "Okey";
        return "No";
    }
}
