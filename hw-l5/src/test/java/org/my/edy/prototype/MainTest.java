package org.my.edy.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ConcreteA concreteA;

    @BeforeEach
    void setUp() {
        concreteA = new ConcreteA();

        concreteA.setId(1);
        concreteA.setName("Name");
    }

    @Test
    void clonable() {
        ConcreteA clone = concreteA.clone();

        assertNotNull(clone);
        assertEquals(concreteA.getId(), clone.getId());
        assertEquals(concreteA.getName(), clone.getName());
    }

    @Test
    void second_clonable() {
        ConcreteA clone = concreteA.clone();
        ConcreteA secondClone = clone.clone();

        assertNotNull(clone);
        assertNotNull(secondClone);
        assertEquals(concreteA.getId(), clone.getId());
        assertEquals(concreteA.getName(), clone.getName());
        assertEquals(clone.getId(), secondClone.getId());
        assertEquals(clone.getName(), secondClone.getName());
    }
}