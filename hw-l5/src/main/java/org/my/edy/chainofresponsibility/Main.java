package org.my.edy.chainofresponsibility;

import org.my.edy.chainofresponsibility.handler.FirstHandler;
import org.my.edy.chainofresponsibility.handler.Handler;
import org.my.edy.chainofresponsibility.handler.SecondRequest;
import org.my.edy.chainofresponsibility.handler.ThirdHandler;

public class Main {
    static void main() {
        Handler handlerChain;

        handlerChain = createChain();
        if (handlerChain == null)
            throw new RuntimeException("Цепочка пуста");

        ExampleRequest request11 = new ExampleRequest("12345678901");
        ExampleRequest request10 = new ExampleRequest("1234567890");
        ExampleRequest request6 = new ExampleRequest("123456");
        ExampleRequest request5 = new ExampleRequest("12345");
        ExampleRequest request2 = new ExampleRequest("12");
        ExampleRequest request1 = new ExampleRequest("1");
        ExampleRequest request0 = new ExampleRequest("");

        handlerChain.handle(request0);
        handlerChain.handle(request1);
        handlerChain.handle(request2);
        handlerChain.handle(request5);
        handlerChain.handle(request6);
        handlerChain.handle(request10);
        handlerChain.handle(request11);
    }

    private static Handler createChain() {
        try {
            Handler first = new FirstHandler();
            Handler second = new SecondRequest();
            Handler third = new ThirdHandler();

            first.setNext(second);
            second.setNext(third);

            return first;

        } catch (Exception e) {
            return null;
        }

    }
}
