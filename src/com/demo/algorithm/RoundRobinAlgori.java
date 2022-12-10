package com.demo.algorithm;

import com.demo.eas.EASServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinAlgori {

    public static AtomicInteger count = new AtomicInteger(-1);

    public static int getEasServer(List<EASServer> easServers) {
        count.addAndGet(1);
        if (count.intValue() >= easServers.size()) {
            count.set(0);
        }
        return count.intValue();
    }

}
