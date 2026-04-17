package org.my.edy.adapter;

import java.util.Arrays;

public class Main {
    static void main() {
        ClientInterface client = new Client();
        ServiceInterface service = new Service();
        ClientInterface adapter = new ServiceAdapter(service);

        boolean clientRes = client.businessLogic(5);
        char[] serviceRes = service.specialMethod("12345");
        boolean adapterRes = adapter.businessLogic(5);

        IO.println(clientRes);
        IO.println(Arrays.toString(serviceRes));
        IO.println(adapterRes);
    }
}
