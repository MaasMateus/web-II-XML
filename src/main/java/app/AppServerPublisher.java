package app;

import javax.xml.ws.Endpoint;

public class AppServerPublisher {

    public static void main(String[] args)
    {
        Endpoint.publish("http://127.0.0.1:9876/app",
                new AppServerImpl());
    }
}