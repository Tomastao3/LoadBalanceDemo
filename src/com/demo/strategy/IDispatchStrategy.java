package com.demo.strategy;

import com.demo.eas.EASServer;

import java.util.List;

public interface IDispatchStrategy {
   public int executeStrategy(List<EASServer> easServers) throws ClassNotFoundException;
}