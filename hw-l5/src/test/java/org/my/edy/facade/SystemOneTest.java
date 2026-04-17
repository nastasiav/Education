package org.my.edy.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemOneTest {
    SystemOne systemOne = new SystemOne();

    @Test
    void checkAvailability_false() {
        boolean res = systemOne.checkAvailability(2.0);
        assertFalse(res);
    }


    @Test
    void checkAvailability_true() {
        boolean res = systemOne.checkAvailability(6.0);
        assertTrue(res);
    }
}