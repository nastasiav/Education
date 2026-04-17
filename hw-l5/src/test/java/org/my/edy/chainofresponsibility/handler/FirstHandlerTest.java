package org.my.edy.chainofresponsibility.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.my.edy.chainofresponsibility.ExampleRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FirstHandlerTest {

    private FirstHandler handler;

    @Mock
    private BaseHandler baseHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        handler = new FirstHandler();
        handler.setNext(baseHandler);
    }

    @Test
    public void test_length11() {
        ExampleRequest rq = new ExampleRequest("12345678901");
        handler.handle(rq);

        verify(baseHandler, never()).handle(any());
    }

    @Test
    void test_length10() {
        ExampleRequest request = new ExampleRequest("1234567890");
        handler.handle(request);
        verify(baseHandler, times(1)).handle(eq(request));
    }

    @Test
    void test_length5() {
        ExampleRequest request = new ExampleRequest("12345");

        handler.handle(request);

        verify(baseHandler, times(1)).handle(eq(request));
    }

    @Test
    void test_length0() {
        ExampleRequest request = new ExampleRequest("");

        handler.handle(request);

        verify(baseHandler, times(1)).handle(eq(request));
    }


    @Test
    void test_length_null() {
        ExampleRequest request = new ExampleRequest(null);

        assertThrows(RuntimeException.class, () -> handler.handle(request));
    }


    @Test
    void test_null() {
        assertThrows(RuntimeException.class, () -> handler.handle(null));
    }
}