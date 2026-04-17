package org.my.edy.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemTwoTest {
    SystemTwo systemTwo = new SystemTwo();

    @Test
    void calculate() {
        double res = systemTwo.calculate("Data");

        assertEquals(8.0, res);
    }

    @Test
    void calculate_2() {
        double res = systemTwo.calculate("");

        assertEquals(0.0, res);
    }
}