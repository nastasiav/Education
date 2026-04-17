package org.my.edy.chainofresponsibility.handler;

import org.my.edy.chainofresponsibility.ExampleRequest;

public class BaseHandler implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handle(ExampleRequest request) {
        IO.println(this.toString());
        if (next != null) {
            next.handle(request);
        } else {
            IO.println("Запрос не может быть обработан: нет подходящего обработчика");
        }
    }
}
