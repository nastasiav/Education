package org.my.edy;

import java.util.Map;
import java.util.TreeMap;

//В чём разница между Comparable и Comparator? Приведите пример когда нужен каждый.
//TODO
public class Task2 {
    static void main() {
        exampleComparator();
        exampleComparator2();

    }

    private static void exampleComparator() {
        Map<String, Integer> map = new TreeMap<>(new MyComparator());

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            key.append(i);
            map.put(key.toString(), i);
        }

        IO.println(map);
    }

    private static void exampleComparator2() {
        Map<String, Integer> map = new TreeMap<>((s1, s2) -> Integer.compare(s2.length(), s1.length()));

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            key.append(i);
            map.put(key.toString(), i);
        }

        IO.println(map);
    }
}
