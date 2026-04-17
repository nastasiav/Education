package org.my.edy.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemThreeTest {
    SystemThree systemThree = new SystemThree();

    @Test
    void testing() {
        String res = systemThree.testing(1);
        assertEquals("Okey", res);
    }

    @Test
    void testing_2() {
        String res = systemThree.testing(-1);
        assertEquals("No", res);
    }

    @Test
    void testing_3() {
        String res = systemThree.testing(0);
        assertEquals("No", res);
    }
}