package org.my.edy.carfactory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.CountDownLatch;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
//not in use
public class Worker implements Runnable {
    String name;
    String begin;
    String end;
    int ms;
    CountDownLatch latch;

    public Worker(int number, String begin, String end, int ms, CountDownLatch latch) {
        this.name = number + "-Worker";
        this.begin = begin;
        this.end = end;
        this.ms = ms;
        this.latch = latch;
        System.out.println(name + " создан");
    }

    @Override
    public void run() {
        System.out.println(name + " запущен");
        System.out.println(begin);
        sleep(ms);
        latch.countDown();
        System.out.println(end);
    }

    void sleep(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
