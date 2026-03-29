package org.my.edy.pool.forkjoinpool;

//--------------------------- WorkStealingPool (ForkJoinPool) ---------------------------
// Пул который разбивает большую задачу на маленькие подзадачи
// Потоки которые закончили свои задачи — воруют задачи у занятых потоков
// Используй для рекурсивных задач которые можно разбить на части
// Количество потоков = количеству ядер процессора

//------ TASK

// Посчитай сумму массива из 1 000 000 чисел
// Разбей массив на две половины — каждую считает отдельная подзадача
// Подзадачи тоже делятся пока не дойдут до размера 1000
// Сравни время с обычным однопоточным подсчётом
//ForkJoinPool pool = new ForkJoinPool();

// TODO: создай класс SumTask который extends RecursiveTask<Long>
// если размер массива <= 1000 — считай сумму напрямую
// иначе — раздели на две половины через invokeAll()
// запусти через pool.invoke() и напечатай результат


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class WorkStealingPoolTask {
    static void main() {
        int[] array1K = new int[1000];
        int[] array1M = new int[1_000_000];
        Arrays.fill(array1K, 1);
        Arrays.fill(array1M, 1);

        sumWithoutThreads(array1K);
        sumWithoutThreads(array1M);
        sumWithForkJoinPool(array1K);
        sumWithForkJoinPool(array1M);
    }

    private static void sumWithForkJoinPool(int[] array) {
        SumTask sumTask = new SumTask(array, 0, array.length);

        ForkJoinPool pool = new ForkJoinPool();
        long start = System.nanoTime();

        Long sum = pool.invoke(sumTask);

        long end = System.nanoTime();
        System.out.printf("ForkJoinPool - Сумма равна: %d и посчитана за: %d мс (%d нс).%n", sum, (end - start) / 1_000_000, (end - start));

        pool.close();
    }

    private static void sumWithoutThreads(int[] array) {
        long sum = 0L;
        long start = System.nanoTime();
        for (int j : array) {
            sum += j;
        }
        long end = System.nanoTime();
        System.out.printf("FOR - Сумма равна: %d и посчитана за: %d мс (%d нс).%n", sum, (end - start) / 1_000_000, (end - start));
    }
}

//FOR - Сумма равна: 1000 и посчитана за: 0 мс (8167 нс).
//FOR - Сумма равна: 1000000 и посчитана за: 2 мс (2967333 нс).
//ForkJoinPool - Сумма равна: 1000 и посчитана за: 0 мс (277750 нс).
//ForkJoinPool - Сумма равна: 1000000 и посчитана за: 5 мс (5204458 нс).

//FOR - Сумма равна: 1000 и посчитана за: 0 мс (9167 нс).
//FOR - Сумма равна: 1000000 и посчитана за: 2 мс (2794125 нс).
//ForkJoinPool - Сумма равна: 1000 и посчитана за: 0 мс (262833 нс).
//ForkJoinPool - Сумма равна: 1000000 и посчитана за: 5 мс (5268375 нс).