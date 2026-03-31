package org.my.edy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task3 {
    static void main() {
        List<String> names = new ArrayList<>(List.of("Борис", "Анна", "Дима"));
        names.sort(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));
        System.out.println(names);
    }
}
