package org.my.edy.chainofresponsibility.handler;

import org.my.edy.chainofresponsibility.ExampleRequest;

public class SecondRequest extends BaseHandler {
    @Override
    public void handle(ExampleRequest request) {
        if (request == null || request.getText() == null)
            throw new RuntimeException("Null Request");
        if (request.getText().length() > 5) {
            IO.println("SecondRequest обработал запрос");
        }
        else {
            super.handle(request);
        }
    }
}
