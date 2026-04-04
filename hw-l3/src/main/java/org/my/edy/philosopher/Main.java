package org.my.edy.philosopher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int FORK_COUNT = 5;
    private static final int PHILOSOPHER_COUNT = 5;

    static void main() throws InterruptedException {
        List<Fork> forks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();
        List<Thread> philosopherThreads = new ArrayList<>();

        for (int i = 0; i < FORK_COUNT; i++) {
            forks.add(new Fork(i));
        }

        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            Fork left = forks.get(i);
            Fork right = forks.get((i + 1) % FORK_COUNT);
            philosophers.add(new Philosopher(i, left, right, 1000, 1000));
        }

        for (Philosopher philosopher : philosophers) {
            Thread thread = new Thread(philosopher);
            philosopherThreads.add(thread);
            thread.start();
        }

        Thread.sleep(10_000);
        for (Thread th : philosopherThreads) {
            th.interrupt();
        }

        for (Thread th : philosopherThreads) {
            th.join();
        }

    }
}
