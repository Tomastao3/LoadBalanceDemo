package com.demo.strategy;

import com.demo.eas.EASServer;

import java.util.List;

public class DoStrategy {
   private IDispatchStrategy strategy;
 
   public DoStrategy(IDispatchStrategy strategy){
      this.strategy = strategy;
   }
 
   public int executeStrategy(List<EASServer> easServers) throws ClassNotFoundException {
      return strategy.executeStrategy( easServers);
   }
}
