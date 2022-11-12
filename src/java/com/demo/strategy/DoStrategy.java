package java.com.demo.strategy;

public class DoStrategy {
   private IDispatchStrategy strategy;
 
   public DoStrategy(IDispatchStrategy strategy){
      this.strategy = strategy;
   }
 
   public int executeStrategy(){
      return strategy.executeStrategy();
   }
}
