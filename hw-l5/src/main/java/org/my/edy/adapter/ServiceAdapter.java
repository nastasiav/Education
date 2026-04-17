package org.my.edy.adapter;


public class ServiceAdapter implements ClientInterface{
    ServiceInterface service;

    public ServiceAdapter(ServiceInterface service) {
        this.service = service;
    }

    @Override
    public boolean businessLogic(int count) {
        String data = convertToSpetialData(count);
        char[] result = service.specialMethod(data);

        return result.length == 5;
    }

    private String convertToSpetialData(int count) {
        return "s".repeat(Math.max(0, count));
    }
}
