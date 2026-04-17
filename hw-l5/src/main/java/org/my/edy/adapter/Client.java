package org.my.edy.adapter;

public class Client implements ClientInterface {
    @Override
    public boolean businessLogic(int count) {
        return count == 5;
    }
}
