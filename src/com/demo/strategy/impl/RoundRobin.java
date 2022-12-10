package com.demo.strategy.impl;

import com.demo.algorithm.RoundRobinAlgori;
import com.demo.eas.EASServer;
import com.demo.strategy.IDispatchStrategy;
import java.util.List;

public class RoundRobin implements IDispatchStrategy {
    @Override
    public int executeStrategy(List<EASServer> easServers) throws ClassNotFoundException {
        return RoundRobinAlgori.getEasServer(easServers);
    }
}
