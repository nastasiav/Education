package org.my.edy.pool.scheduler;


//--------------------------- ScheduledThreadPool ---------------------------
// Пул для задач которые нужно выполнять по расписанию
// Может запускать задачу один раз с задержкой
// или повторять её каждые N секунд
// Используй вместо Thread.sleep() для периодических задач

//------ TASK

// Запусти задачу которая печатает время каждую секунду
// Через 5 секунд останови пул
// Увидишь что задача запускается строго по расписанию
// Попробуй scheduleAtFixedRate vs scheduleWithFixedDelay — в чём разница?
//ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

// TODO: запусти задачу которая печатает текущее время
// с начальной задержкой 0 и повтором каждую 1 секунду
// через 5 секунд вызови executor.shutdown()

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTask_V2 {
    static void main() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        executor.schedule(new SchedulerTask(executor), 0, TimeUnit.SECONDS);

        Thread.sleep(5000);
        executor.shutdown();
    }
}

//Задача исполняется в треде: pool-1-thread-1
//        2026-03-23T01:03:13.561176
//Задача исполняется в треде: pool-1-thread-2
//        2026-03-23T01:03:14.567171
//Задача исполняется в треде: pool-1-thread-2
//        2026-03-23T01:03:15.570157
//Задача исполняется в треде: pool-1-thread-2
//        2026-03-23T01:03:16.575983
//Задача исполняется в треде: pool-1-thread-2
//        2026-03-23T01:03:17.581476
//Задача исполняется в треде: pool-1-thread-1
//        2026-03-23T01:03:18.582084
