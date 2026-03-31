package org.my.edy;

public class Task7 {
    static void main() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                synchronized (lock2) { System.out.println("T1"); }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) { System.out.println("T2"); }
            }

        });
        t1.start();
        t2.start();
    }
}
