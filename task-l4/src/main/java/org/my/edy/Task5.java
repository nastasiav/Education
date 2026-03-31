package org.my.edy;

import java.util.HashMap;
import java.util.Map;

public class Task5 {
    static void main() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("a", 3);
        System.out.println(map.size() + " " + map.get("a"));
    }
}
