package org.my.edy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyComparableObject implements Comparable<MyComparableObject> {
    String field;

    public MyComparableObject(String field) {
        this.field = field;
    }

    @Override
    public int compareTo(MyComparableObject o) {
        return Integer.compare(this.getField().length(),
                o.getField().length())
                * (-1);
    }
}
