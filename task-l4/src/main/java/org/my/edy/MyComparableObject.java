package org.my.edy;

@Getter
public class MyComparableObject implements Comparable<String> {

    @Override
    public int compareTo(String o) {
        return Integer.compare(o);
    }
}
