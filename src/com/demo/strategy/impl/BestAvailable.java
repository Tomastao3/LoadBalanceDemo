package com.demo.strategy.impl;

import com.demo.algorithm.RandomAlgori;
import com.demo.eas.EASServer;
import com.demo.strategy.IDispatchStrategy;

import java.util.List;

public class BestAvailable implements IDispatchStrategy {
   @Override
   public int executeStrategy(List<EASServer> easServers) {
      return RandomAlgori.getEasServer(easServers);
   }
}
