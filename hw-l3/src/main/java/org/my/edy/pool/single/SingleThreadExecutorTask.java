package org.my.edy.pool.single;

//--------------------------- SingleThreadExecutor ---------------------------
// Пул из ровно одного потока
// Все задачи выполняются строго по очереди одна за другой
// Гарантирует порядок выполнения задач
// Используй когда задачи нельзя выполнять параллельно

//------ TASK

// Отправь 5 задач с номерами 1-5
// Увидишь что они выполняются строго по порядку: 1, 2, 3, 4, 5
// Попробуй заменить на FixedThreadPool(3) — порядок нарушится
// SingleThreadExecutor гарантирует что задача 2 начнётся только после задачи 1
//ExecutorService executor = Executors.newSingleThreadExecutor();

// TODO: отправь 5 задач пронумерованных от 1 до 5
// каждая задача печатает свой номер
// убедись что они всегда печатаются в порядке 1 2 3 4 5

import org.my.edy.pool.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTask {

    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            executor.submit(new Task(i));
        }

        executor.shutdown();

    }
}


//Задача исполняется таском-1 в треде: pool-1-thread-1
//Задача исполнена таском-1 за: 1c
//Задача исполняется таском-2 в треде: pool-1-thread-1
//Задача исполнена таском-2 за: 2c
//Задача исполняется таском-3 в треде: pool-1-thread-1
//Задача исполнена таском-3 за: 3c
//Задача исполняется таском-4 в треде: pool-1-thread-1
//Задача исполнена таском-4 за: 4c
//Задача исполняется таском-5 в треде: pool-1-thread-1
//Задача исполнена таском-5 за: 5c