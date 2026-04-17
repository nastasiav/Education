package org.my.edy.singleton;

public class Main {
    static void main() {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
    }
}
