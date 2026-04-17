package org.my.edy.adapter;

public class Service implements ServiceInterface{

    @Override
    public char[] specialMethod(String data) {
        return data.toCharArray();
    }
}
