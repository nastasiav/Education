package org.my.edy.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FacadeTest {

    private SystemOne systemOne;
    private SystemTwo systemTwo;
    private SystemThree systemThree;
    private Facade facade;

    @BeforeEach
    void setUp() {
        systemOne = mock(SystemOne.class);
        systemTwo = mock(SystemTwo.class);
        systemThree = mock(SystemThree.class);
        facade = new Facade(systemOne, systemTwo, systemThree);
    }

    @Test
    void testFullBusinessLogic() {
        int input = 5;
        String expectedFromSystemThree = "Okey";
        double expectedFromSystemTwo = 8.0;
        boolean expectedResult = true;

        when(systemThree.testing(input)).thenReturn(expectedFromSystemThree);
        when(systemTwo.calculate(expectedFromSystemThree)).thenReturn(expectedFromSystemTwo);
        when(systemOne.checkAvailability(expectedFromSystemTwo)).thenReturn(expectedResult);

        boolean result = facade.fullBusinessLogic(input);

        assertTrue(result);
        verify(systemThree, times(1)).testing(input);
        verify(systemTwo, times(1)).calculate(expectedFromSystemThree);
        verify(systemOne, times(1)).checkAvailability(expectedFromSystemTwo);
    }

    @Test
    void testFullBusinessLogic_false() {
        int input = 3;
        String fromSystemThree = "Okey";
        double fromSystemTwo = 8.0;
        boolean expectedResult = false;
        double lowCost = 4.0;

        when(systemThree.testing(input)).thenReturn(fromSystemThree);
        when(systemTwo.calculate(fromSystemThree)).thenReturn(lowCost);
        when(systemOne.checkAvailability(lowCost)).thenReturn(false);

        boolean result = facade.fullBusinessLogic(input);

        assertFalse(result);
        verify(systemThree, times(1)).testing(input);
        verify(systemTwo, times(1)).calculate(fromSystemThree);
        verify(systemOne, times(1)).checkAvailability(lowCost);
    }

    @Test
    void testFullBusinessLogic_0() {
        int input = 0;
        String fromSystemThree = "No";
        double fromSystemTwo = 4.0;
        boolean expectedResult = false;

        when(systemThree.testing(input)).thenReturn(fromSystemThree);
        when(systemTwo.calculate(fromSystemThree)).thenReturn(fromSystemTwo);
        when(systemOne.checkAvailability(fromSystemTwo)).thenReturn(expectedResult);

        boolean result = facade.fullBusinessLogic(input);

        assertFalse(result);
        verify(systemThree, times(1)).testing(input);
        verify(systemTwo, times(1)).calculate(fromSystemThree);
        verify(systemOne, times(1)).checkAvailability(fromSystemTwo);
    }

    @Test
    void testFullBusinessLogic_neg() {
        int input = -5;
        String fromSystemThree = "No";
        double fromSystemTwo = 4.0;
        boolean expectedResult = false;

        when(systemThree.testing(input)).thenReturn(fromSystemThree);
        when(systemTwo.calculate(fromSystemThree)).thenReturn(fromSystemTwo);
        when(systemOne.checkAvailability(fromSystemTwo)).thenReturn(expectedResult);

        boolean result = facade.fullBusinessLogic(input);

        assertFalse(result);
        verify(systemThree, times(1)).testing(input);
        verify(systemTwo, times(1)).calculate(fromSystemThree);
        verify(systemOne, times(1)).checkAvailability(fromSystemTwo);
    }
}