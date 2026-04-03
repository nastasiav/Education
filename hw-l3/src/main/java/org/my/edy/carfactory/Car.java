package org.my.edy.carfactory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    boolean body;
    boolean engine;
    boolean wheels;
    boolean color;
    boolean details;

    public Car() {
        this.body = false;
        this.engine = false;
        this.wheels = false;
        this.color = false;
        this.details = false;
    }

    public boolean paintAndInstall() {
        this.color = true;
        if (body && engine && wheels)
            this.details = true;

        return color && details;
    }

    public boolean finalCheck() {
        return body && engine && wheels && color && details;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", engine=" + engine +
                ", wheels=" + wheels +
                ", color=" + color +
                ", details=" + details +
                '}';
    }
}
