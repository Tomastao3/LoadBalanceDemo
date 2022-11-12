package java.com.demo.eas;

import java.com.demo.eas.appengin.AppEngin;
import java.com.demo.strategy.DoStrategy;
import java.com.demo.strategy.impl.BestAvailable;
import java.com.demo.strategy.impl.Random;
import java.com.demo.strategy.impl.RoundRobin;
import java.util.List;

public class EASServer {
    int serverID;
    float availableMemory;
    int avaiableCPU;
    int healthyScore;
    boolean isAlive;
    List<AppEngin> appEngin;

    final int BEST_AVAILABLE_STRTAGY = 1;
    final int ROUND_ROBIN_STRTAGY = 2;
    final int RANDOM_STRTAGY = 3;

    public void registerEngin(AppEngin enginName){

    }

    public void reportHeart(){

    }

    public void dispatchToServer(int strategyType) {
        DoStrategy doStrategy = new DoStrategy(new BestAvailable());

        switch (strategyType) {
            case BEST_AVAILABLE_STRTAGY:
                doStrategy = new DoStrategy(new BestAvailable());
                doStrategy.executeStrategy();
                break;
            case ROUND_ROBIN_STRTAGY:
                doStrategy = new DoStrategy(new Random());
                doStrategy.executeStrategy();
                break;
            case RANDOM_STRTAGY:
                doStrategy = new DoStrategy(new RoundRobin());
                doStrategy.executeStrategy();
                break;
        }

        doStrategy = new DoStrategy(new RoundRobin());
        doStrategy = new DoStrategy(new Random());
    }



}
