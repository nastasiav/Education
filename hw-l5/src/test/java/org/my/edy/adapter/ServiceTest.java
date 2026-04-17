package org.my.edy.adapter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    ServiceInterface service = new Service();

    @Test
    public void expectedCharArray() {
        char[] array = service.specialMethod("ssss");

        assertNotNull(array);
        assertEquals(4, array.length);
    }


    @Test
    public void expectedCharArrayAll() {
        char[] array = service.specialMethod("ssss");
        char[] ex = new char[4];
        Arrays.fill(ex, 's');

        assertNotNull(array);
        assertEquals(4, array.length);
        assertArrayEquals(ex, array);
    }

}