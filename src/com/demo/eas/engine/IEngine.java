package com.demo.eas.engine;

import com.demo.eas.EASServer;
import com.demo.eas.engine.impl.AppEngine1;

public interface IEngine {

    void init(EASServer easServer);

    public void service() throws ClassNotFoundException;

    void destroy();

    public static void main(String[] args) {
        System.out.println(AppEngine1.class);
    }
}
