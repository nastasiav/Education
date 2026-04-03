package org.my.edy.vt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ServerBenchmark_V2 {

    private static final int REQUESTS = 10_000;

    // Имитация запроса к базе данных
    static String handleRequest(int requestId) throws InterruptedException {
        Thread.sleep(50);
        return Thread.currentThread().isVirtual() ? "virtual" : Thread.currentThread().getName();
    }

    // TODO: реализуй через Executors.newFixedThreadPool(200)
    // отправь REQUESTS задач в пул, собери результаты через Future
    // замерь время через System.currentTimeMillis()
    // верни количество миллисекунд которое заняла обработка
    static Result processWithPlatformThreads() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        List<Future<String>> futures = new ArrayList<>();
        List<String> result = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < REQUESTS; i++) {
            int finalI = i;
            futures.add(executorService.submit( () -> handleRequest(finalI)));
        }

        for (Future<String> future : futures) {
            result.add(future.get());
        }

        executorService.shutdown();
        return new Result(System.currentTimeMillis() - start, result);
    }

    // TODO: реализуй через Executors.newVirtualThreadPerTaskExecutor()
    // логика та же что и в processWithPlatformThreads()
    // единственное отличие — тип пула
    static Result processWithVirtualThreads() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        long start = System.currentTimeMillis();
        List<Future<String>> futures = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < REQUESTS; i++) {
            int finalI = i;
            futures.add(executorService.submit(() -> handleRequest(finalI)));
        }
        for (Future<String> future : futures) {
            result.add(future.get());
        }

        executorService.shutdown();
        return new Result(System.currentTimeMillis() - start, result);
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Запросов: " + REQUESTS);
        System.out.println("Задержка на запрос: 50ms");
        System.out.println("=".repeat(40));

        // Прогрев JVM — первый запуск всегда медленнее
        // JVM оптимизирует код во время выполнения (JIT компиляция)
        // поэтому прогреваем перед реальным замером
        System.out.println("Прогрев JVM...");
        processWithPlatformThreads();
        processWithVirtualThreads();
        System.out.println("Прогрев завершён");
        System.out.println("=".repeat(40));

        long platformTime = processWithPlatformThreads().getTime();
        System.out.println("Обычные потоки:     " + platformTime + " ms");

        long virtualTime = processWithVirtualThreads().getTime();
        System.out.println("Виртуальные потоки: " + virtualTime + " ms");

        System.out.println("=".repeat(40));
        System.out.printf("Виртуальные быстрее в: %.1fx%n", (double) platformTime / virtualTime);
    }
}

//Запросов: 10000
//Задержка на запрос: 50ms
//========================================
//Прогрев JVM...
//Прогрев завершён
//========================================
//Обычные потоки:     2689 ms
//Виртуальные потоки: 135 ms
//========================================
//Виртуальные быстрее в: 19,9x



//Запросов: 10000
//Задержка на запрос: 50ms
//========================================
//Прогрев JVM...
//Прогрев завершён
//========================================
//Обычные потоки:     2695 ms
//Виртуальные потоки: 73 ms
//========================================
//Виртуальные быстрее в: 36,9x