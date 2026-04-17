package org.my.edy.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    ClientInterface client = new Client();

    @Test
    void businessLogic_expectedTrue() {
        boolean result = client.businessLogic(5);

        assertTrue(result);
    }

    @Test
    void businessLogic_expectedfalse() {
        boolean result = client.businessLogic(3);

        assertFalse(result);
    }
}