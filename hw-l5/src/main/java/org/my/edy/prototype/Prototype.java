package org.my.edy.prototype;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Prototype {
    String name;
    int id;

    public Prototype() {
    }

    public Prototype(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Prototype(Prototype source) {
        super();
        this.name = source.getName();
        this.id = source.getId();
    }

    public abstract Prototype clone();

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
