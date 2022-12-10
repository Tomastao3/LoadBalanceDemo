package com.demo.algorithm;

import com.demo.eas.EASServer;

import java.util.List;
import java.util.Random;

public class RandomAlgori {

    private volatile static Random random;

    public static Random getRandomInstance() {
        if (random == null) {
            synchronized (Random.class) {
                if (random == null) {
                    random = new Random();
                }
            }
        }
        return random;
    }

    public static int getEasServer(List<EASServer> easServers){
        return getRandomInstance().nextInt(easServers.size());
    }


}
