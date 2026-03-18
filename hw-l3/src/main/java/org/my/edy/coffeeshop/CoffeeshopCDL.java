package org.my.edy.coffeeshop;
/*

Бариста ждёт заказов...
Клиент-1 добавил заказ: Латте
Клиент-2 добавил заказ: Капучино
Клиент-3 добавил заказ: Эспрессо
Бариста готовит: Латте
Бариста готовит: Капучино
Бариста готовит: Эспрессо
Бариста: все заказы выполнены!

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CoffeeshopCDL {

    private static final Queue<String> orders = new LinkedList<>();
    private static final Object lock = new Object();
    private static boolean open = true; // кофейня открыта

    static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        // Бариста
        Thread barista = new Thread(() -> {
            synchronized (lock) {
                while (open || !orders.isEmpty()) {
                    if (orders.isEmpty()) {
                        try {
                            System.out.println("Бариста ждёт заказов...");
                            // TODO: бариста засыпает пока нет заказов
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String order = orders.poll();
                        // TODO: бариста готовит кофе 1 секунду
                        // не забудь отпустить lock пока готовит!

                        System.out.println("Бариста готовит: " + order);
                        try {
                            lock.wait(1000);
                            latch.countDown();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            System.out.println("Бариста: все заказы выполнены!");
        });

        // Клиенты
        String[] coffees = {"Латте", "Капучино", "Эспрессо"};
        Thread[] clients = new Thread[coffees.length];

        for (int i = 0; i < coffees.length; i++) {
            String coffee = coffees[i];
            String name = "Клиент-" + (i + 1);
            clients[i] = new Thread(() -> {
                // TODO: добавь заказ в очередь и разбуди баристу
                orders.add(coffee);
                System.out.println(name + " добавил заказ: " + coffee);
            });
        }

        barista.start();
        Thread.sleep(200); // даём баристе успеть запуститься

        for (Thread client : clients) {
            client.start();
            Thread.sleep(100); // клиенты приходят с небольшой паузой
        }

        // Ждём пока все клиенты добавят заказы
        for (Thread client : clients) {
            client.join();
        }

        synchronized (lock) {
            lock.notify();
        }

        latch.await();
        synchronized (lock) {
            open = false;
            lock.notify();
        }

        // TODO: закрой кофейню и разбуди баристу чтобы он завершил работу
        barista.join();
    }
}