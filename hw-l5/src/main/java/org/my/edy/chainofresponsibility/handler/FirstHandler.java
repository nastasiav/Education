package org.my.edy.chainofresponsibility.handler;

import org.my.edy.chainofresponsibility.ExampleRequest;

public class FirstHandler extends BaseHandler {
    @Override
    public void handle(ExampleRequest request) {
        if (request == null || request.getText() == null)
            throw new RuntimeException("Null Request");
        if (request.getText().length() > 10) {
            IO.println("FirstHandler обработал запрос");
        } else {
            super.handle(request);
        }
    }
}
