package org.my.edy.carfactory;

/*

. Сборка машины состоит из этапов,
которые зависят друг от друга — нельзя красить кузов пока он не сварен,
нельзя запускать двигатель пока он не установлен.

Есть конвейер сборки автомобиля. Этапы выполняются параллельно где можно, но некоторые ждут других.
Этап 1а: Сварить кузов        (2 сек) ─┐
Этап 1б: Собрать двигатель    (3 сек) ─┤─► Этап 2: Покраска и установка (2 сек) ──► Этап 3: Финальная проверка (1 сек)
Этап 1в: Сделать колёса       (1 сек) ─┘
Правила:

Этапы 1а, 1б, 1в идут параллельно
Этап 2 начинается только когда все три этапа 1 завершены
Этап 3 начинается только когда завершён этап 2


---

**Ожидаемый вывод:**
```
Начало сборки автомобиля...
▶ Свариваем кузов...
▶ Собираем двигатель...
▶ Делаем колёсa...
✔ Колёса готовы
✔ Кузов готов
✔ Двигатель готов
▶ Красим кузов и устанавливаем детали...
✔ Покраска и установка завершены
▶ Финальная проверка...
✔ Автомобиль готов к продаже!
Сборка заняла: 6 секунд  ← не 9! потому что этап 1 шёл параллельно

*/

import java.util.concurrent.*;

public class CarFactoryWorkers {

    static void main(String[] args) throws InterruptedException, RuntimeException {
        CountDownLatch latch = new CountDownLatch(3);

        System.out.println("Начало сборки автомобиля...");
        long start = System.currentTimeMillis();

        // Этап 1 — параллельные задачи

        // Этап 2 — покраска и установка
        Runnable paintAndInstall =() -> {
            System.out.println("▶ Красим кузов и устанавливаем детали...");
            sleep(2000);
            System.out.println("✔ Покраска и установка завершены");
        };

        // Этап 3 — финальная проверка
        Runnable finalCheck = () -> {
            System.out.println("▶ Финальная проверка...");
            sleep(1000);
            System.out.println("✔ Автомобиль готов к продаже!");
        };

        // TODO
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Worker(1, "▶ Свариваем кузов...", "✔ Кузов готов", 2000, latch));
        pool.submit(new Worker(2, "▶ Собираем двигатель...", "✔ Двигатель готов", 3000, latch));
        pool.submit(new Worker(3, "▶ Делаем колёса...", "✔ Колёса готовы", 1000, latch));

        latch.await();

        try {
            pool.submit(paintAndInstall).get(3000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        try {
            pool.submit(finalCheck).get(3000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }


        pool.shutdown();


        long time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Сборка заняла: " + time + " секунд");
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}

