package org.my.edy.chainofresponsibility.handler;

import org.my.edy.chainofresponsibility.ExampleRequest;

public class ThirdHandler extends BaseHandler {
    @Override
    public void handle(ExampleRequest request) {
        if (request == null || request.getText() == null)
            throw new RuntimeException("Null Request");
        if (request.getText().length() > 2) {
            IO.println("ThirdHandler обработал запрос");
        } else {
            super.handle(request);
        }
    }
}
