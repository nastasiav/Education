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

public class CoffeeshopCDLZweiBaristas {

    private static final Queue<String> orders = new LinkedList<>();
    private static final Object lock = new Object();
    private static volatile boolean open = true; // кофейня открыта

    static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Thread closeCoffeeShop = new Thread(() -> {
            try {
                latch.await();
                synchronized (lock) {
                    open = false;
                    lock.notifyAll(); // разбудить всех барист,
                    System.out.println("Кофейня закрывается!");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Клиенты
        String[] coffees = {"Латте", "Капучино", "Эспрессо"};
        Thread[] clients = new Thread[coffees.length];
        Thread[] baristas = new Thread[2];

        for (int i = 0; i < baristas.length; i++) {
            String name = "Бариста-" + (i + 1);
            baristas[i] = new Thread(() -> {
                synchronized (lock) {
                    while (open || !orders.isEmpty()) {
                        if (orders.isEmpty()) {
                            try {
                                System.out.println(name + " ждёт заказов...");
                                // TODO: бариста засыпает пока нет заказов
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            String order = orders.poll();
                            // TODO: бариста готовит кофе 1 секунду
                            // не забудь отпустить lock пока готовит!
                            lock.notifyAll();

                            System.out.println(name + " готовит: " + order);
                            try {
                                lock.wait(1000);
                                latch.countDown();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                System.out.println(name + ": все заказы выполнены!");
            });
        }

        for (int i = 0; i < coffees.length; i++) {
            String coffee = coffees[i];
            String name = "Клиент-" + (i + 1);
            clients[i] = new Thread(() -> {
                // TODO: добавь заказ в очередь и разбуди баристу
                synchronized (lock) { // queue не потокобезопасна сама по себе
                    orders.add(coffee);
                    System.out.println(name + " добавил заказ: " + coffee);
                }
            });
        }

        closeCoffeeShop.start();
        for (Thread barista : baristas) {
            barista.start();
        }
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

        // TODO: закрой кофейню и разбуди баристу чтобы он завершил работу
        closeCoffeeShop.join();
        for (Thread barista : baristas) {
            barista.join();
        }
    }
}