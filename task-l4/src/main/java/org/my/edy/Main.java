package org.my.edy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Map<String, String> map = new TreeMap<>();
        int x = List.of(1,2,3,4,5).stream().filter(n -> n > 2).map(n -> n * 2).reduce(0, Integer::sum);
        IO.println(x);
    }
}
