package org.my.edy.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceAdapterTest {
    ServiceInterface service = new Service();
    ClientInterface adapter = new ServiceAdapter(service);

    @Test
    void businessLogic_True() {
        int count = 5;
        boolean res = adapter.businessLogic(count);

        assertTrue(res);
    }

    @Test
    void businessLogic_False() {
        int count = 3;
        boolean res = adapter.businessLogic(count);

        assertFalse(res);
    }
}