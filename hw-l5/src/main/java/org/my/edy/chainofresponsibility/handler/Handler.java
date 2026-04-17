package org.my.edy.chainofresponsibility.handler;

import org.my.edy.chainofresponsibility.ExampleRequest;

public interface Handler {
    void setNext(Handler handler);
    void handle(ExampleRequest request);
}
