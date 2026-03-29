package org.my.edy.pool.scheduler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchedulerTask implements Runnable {

    private final ScheduledExecutorService executor;

    public SchedulerTask(ScheduledExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public void run() {
        System.out.println("Задача исполняется в треде: " + Thread.currentThread().getName());
        System.out.println(LocalDateTime.now());
        executor.schedule(this, 1, TimeUnit.SECONDS);
    }
}
