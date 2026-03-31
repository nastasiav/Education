package org.my.edy;

import java.util.List;

public class Task4 {
    static void main() {
        int x = List.of(1,2,3,4,5).stream()
                .filter(n -> n > 2)
                .map(n -> n * 2)
                .reduce(0, Integer::sum);
        IO.println(x);
    }
}
