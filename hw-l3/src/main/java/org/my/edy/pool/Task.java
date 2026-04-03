package org.my.edy.pool;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task implements Runnable {
    int number;
    long start;
    long end;

    public Task(int number) {
        this.number = number;
        this.start = System.currentTimeMillis();
    }

    @Override
    public void run() {
        System.out.println("Задача исполняется таском-" + number + " в треде: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.end = System.currentTimeMillis();
        System.out.println("Задача исполнена таском-" + number + " за: " + (end - start) / 1000 + "c");
    }
}
