package com.demo.eas.engine.impl;


import com.demo.eas.EASServer;
import com.demo.eas.engine.IEngine;
import com.demo.mock.MockHttpRequest;

public class AppEngine2 implements IEngine {
    private String name;
    private String id = this.getClass().toString();
    private EASServer easServer;

    public AppEngine2() {
    }

    @Override
    public void init(EASServer easServer) {
        this.easServer = easServer;
        MockHttpRequest.enginRegister(easServer,this);
    }

    @Override
    public void service() {
        System.out.println("Welcome to "+ easServer.getServerID());
        System.out.println("appEngin_"+ this.id+ "do task");
    }

    @Override
    public void destroy() {

        System.out.println("appEngin_"+ this.id+ "destroyed");
    }

}
