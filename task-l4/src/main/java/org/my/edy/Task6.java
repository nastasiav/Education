package org.my.edy;

public class Task6 {
    private static boolean ready = false;

    static void main() throws InterruptedException {
        Thread writer = new Thread(() -> {
            ready = true;
        });

        Thread reader = new Thread(() -> {
            while (!ready) {}
            System.out.println("Готово!");
        });

        reader.start();
        writer.start();
    }
}
