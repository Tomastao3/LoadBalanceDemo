package com.demo.yaml;

import lombok.Data;
@Data
public class ConfInfo {
    Server server1;
    Server server2;
    Server server3;

    @Data
    public static class Server {
        String id;
        int port;
        Engine engine;
    }
    @Data
    public static class Engine{
        App app;
    }
    @Data
    public static class App{
        String name;
        String url;
        String engineClass;
    }
}
