package org.my.edy.pool.forkjoinpool;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.RecursiveTask;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SumTask extends RecursiveTask<Long> {
    final int[] array;
    final int start;
    final int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        int delta = end - start;
        if (delta <= 1000) {
            long sum = 0L;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }

        int mid = start + delta / 2;

        SumTask left = new SumTask(array, start, mid);
        SumTask right = new SumTask(array, mid, end);

        invokeAll(left, right);

        return left.fork().join() + right.fork().join();
    }
}
