package org.my.edy.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SingletonTest {

    @Test
    public void one_instance() {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        assertNotNull(singleton);
        assertNotNull(singleton2);
        assertEquals(singleton, singleton2);
    }

    @Test
    void constructor_called_one_times() {
        IO mockedIO = mock(IO.class);

        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        verify(mockedIO, times(1)).println("Singleton created");
    }

}