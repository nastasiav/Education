package org.my.edy.philosopher;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Philosopher implements Runnable {
    final int id;
    final Fork leftFork;
    final Fork rightFork;
    final long thinkingTime;
    final long eatingTime;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                thinking();
                eating();
            }
        } catch (InterruptedException _) {
            System.out.println("Philosopher-" + id + " is interruped");
        }
    }

    private void eating() throws InterruptedException {
        if (leftFork.tryLock()) {
            try {
                if (rightFork.tryLock()) {
                    try {
                        System.out.println("Philosopher-" + id + " is eating");
                        Thread.sleep(eatingTime);
                    } finally {
                        rightFork.unlock();
                    }
                }
            }
            finally {
                leftFork.unlock();
            }
        } else {
            Thread.sleep(10);
        }
    }

    private void thinking() throws InterruptedException {
        System.out.println("Philosopher-" + id + " is thinking");
        Thread.sleep(thinkingTime);
    }
}
