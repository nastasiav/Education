package org.my.edy.lazy;

public class LazyInit {

    private static String database = null;

    public synchronized static String getDatabase() {
        if (database == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException _) {}
            database = "Подключение создано потоком: " + Thread.currentThread().getName();
            System.out.println(">>> Создаём подключение: " + database);
        }
        return database;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> System.out.println(getDatabase()), "Поток-1");
        Thread t2 = new Thread(() -> System.out.println(getDatabase()), "Поток-2");
        Thread t3 = new Thread(() -> System.out.println(getDatabase()), "Поток-3");

        t1.start(); t2.start(); t3.start();
        t1.join();  t2.join();  t3.join();
    }
}

//WITHOUT
//>>> Создаём подключение: Подключение создано потоком: Поток-1
//Подключение создано потоком: Поток-2
//        >>> Создаём подключение: Подключение создано потоком: Поток-2
//Подключение создано потоком: Поток-2
//        >>> Создаём подключение: Подключение создано потоком: Поток-3
//Подключение создано потоком: Поток-3


//>>> Создаём подключение: Подключение создано потоком: Поток-1
//Подключение создано потоком: Поток-1
//Подключение создано потоком: Поток-1
//Подключение создано потоком: Поток-1