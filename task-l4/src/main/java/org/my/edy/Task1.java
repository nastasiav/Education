package org.my.edy;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static void main() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        for (Integer i : list) {
            if (i % 2 == 0) {
                //ConcurrentModificationException
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
