
package com.demo.elb;


import com.demo.algorithm.RandomAlgori;
import com.demo.eas.EASServer;
import com.demo.mock.MockHttpRequest;
import com.demo.strategy.DoStrategy;
import com.demo.strategy.impl.BestAvailable;
import com.demo.strategy.impl.Random;
import com.demo.strategy.impl.RoundRobin;

import java.util.ArrayList;
import java.util.List;

public class ELBServer {
    public final static int BEST_AVAILABLE_STRTAGY = 1;
    public final static int ROUND_ROBIN_STRTAGY = 2;
    public final static int RANDOM_STRTAGY = 3;

    String status = "Health";


    private volatile static ELBServer instance;

    public static ELBServer getRandomInstance() {
        if (instance == null) {
            synchronized (java.util.Random.class) {
                if (instance == null) {
                    instance = new ELBServer();
                }
            }
        }
        return instance;
    }

    List<EASServer> easServers= new ArrayList<>();

    public void setStrategy(int strategy) {
        this.strategy = strategy;
    }

    public void showStatus(){
        System.out.println("ELBServer is " + status);
        easServers.forEach((EASServer easServer)->{
            System.out.println(easServer.getServerID() +"'s health score is " + easServer.getHealthyScore());
        });
    }
    public int getStrategy() {
        return strategy;
    }

    int strategy = RANDOM_STRTAGY;

    public void registerServer(EASServer easServer){
        easServers.add(easServer);
    }

    public void moveServerRandom(){
        easServers.remove(RandomAlgori.getEasServer(easServers));
    }

    public void moveServer(EASServer easServer){
        easServers.remove(easServer);
    }

    public void onHeartBeat(){

    }

    public void shutDown(){

    }

    public void processCustomerRequest() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        dispatchToServer();
    }

    public void dispatchToServer() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(easServers.size() == 0){
            System.out.println("there is no EASServer avilable");
            return;
        }
        int server ;
        DoStrategy doStrategy = new DoStrategy(new BestAvailable());

        switch (strategy) {
            case BEST_AVAILABLE_STRTAGY:
                doStrategy = new DoStrategy(new BestAvailable());
                server = doStrategy.executeStrategy(easServers);
                MockHttpRequest.easServerDispatchToEngine(easServers.get(server));
                System.out.printf("balance strategy is BestAvailable\n");
                break;
            case ROUND_ROBIN_STRTAGY:
                doStrategy = new DoStrategy(new RoundRobin());
                server = doStrategy.executeStrategy(easServers);
                MockHttpRequest.easServerDispatchToEngine(easServers.get(server));
                System.out.printf("balance strategy is RoundRobin\n");
                break;
            case RANDOM_STRTAGY:
                doStrategy = new DoStrategy(new Random());
                server = doStrategy.executeStrategy(easServers);
                MockHttpRequest.easServerDispatchToEngine(easServers.get(server));
                System.out.printf("balance strategy is Random\n");
                break;
        }

    }

}

