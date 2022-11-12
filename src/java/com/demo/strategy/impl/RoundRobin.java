package java.com.demo.strategy.impl;



import java.com.demo.strategy.IDispatchStrategy;

public class RoundRobin implements IDispatchStrategy {

   @Override
   public int executeStrategy() {
      return 1;
   }

}