package org.my.edy.chainofresponsibility.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.my.edy.chainofresponsibility.ExampleRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class SecondRequestTest {

    private SecondRequest handler;
    @Mock
    private FirstHandler firstHandler;
    @Mock
    private BaseHandler baseHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        handler = new SecondRequest();
        firstHandler.setNext(handler);
        handler.setNext(baseHandler);
    }

    @Test
    public void test_length6() {
        ExampleRequest rq = new ExampleRequest("123456");
        handler.handle(rq);

        verify(baseHandler, never()).handle(any());
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

    @Test
    void test_chain_1_and_2() {
        ExampleRequest request = new ExampleRequest("12345678901");

        doCallRealMethod()
                .when(firstHandler)
                .handle(any());

        firstHandler.handle(request);

        verify(firstHandler, times(1)).handle(any());
    }
}