package com.demo.mock;

import com.demo.eas.EASServer;
import com.demo.eas.engine.IEngine;
import com.demo.elb.ELBServer;

public class MockHttpRequest {

    public static ELBServer elbServer;

    public static void customerRequest() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        elbServer.dispatchToServer();
    }

    public static void easServerDispatchToEngine(EASServer server) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        server.startEngine();
    }

    public static void easServerRegister(EASServer appServer){
        elbServer.registerServer(appServer);
    }

    public static void enginRegister(EASServer appServer, IEngine engin){
        appServer.registerEngine(engin);
    }

    public static void enginDestroy(EASServer appServer, IEngine engin){
        appServer.destroyEngine(engin);
    }


    public static void setElbServer(ELBServer elbServer) {
        MockHttpRequest.elbServer = elbServer;
    }
}
