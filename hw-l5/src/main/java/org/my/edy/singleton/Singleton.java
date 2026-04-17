package org.my.edy.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        IO.println("Singleton created");
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}

