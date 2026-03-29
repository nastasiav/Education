package org.my.edy.lazy;

public class StopThread {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            int count = 0;
            while (running) {
                count++;
            }
            System.out.println("Поток остановился. Итераций: " + count);
        });

        worker.start();
        Thread.sleep(100);


        running = false;
        System.out.println("Флаг выключен");

        worker.join();
    }
}

//Флаг выключен
//Поток остановился. Итераций: 187413131