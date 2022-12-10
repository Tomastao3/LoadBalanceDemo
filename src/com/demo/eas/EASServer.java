package com.demo.eas;

import com.demo.eas.engine.IEngine;
import com.demo.yaml.ReadYaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EASServer {


    String serverID;
    float availableMemory;
    int avaiableCPU;

    public int getHealthyScore() {
        return healthyScore;
    }

    int healthyScore = 90;
    boolean isAlive;

    List<IEngine> engines = new ArrayList<>();
    String serverStatus = "health";

    final int BEST_AVAILABLE_STRTAGY = 1;
    final int ROUND_ROBIN_STRTAGY = 2;
    final int RANDOM_STRTAGY = 3;

    public String getServerID() {
        return serverID;
    }
    public EASServer(String serverID) {
        this.serverID = serverID;
    }

    public void registerEngine(IEngine engin){
        engines.add(engin);
    }

    public void destroyEngine(IEngine engin){
        engines.remove(engin);
    }

    public void reportHeart(){ }

    public void startEngine() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className ;
        HashMap<String,HashMap> hashInfo = ReadYaml.getYamlHash();
        hashInfo.get(serverID);
        Object clz = Class.forName(getEngineName()).newInstance();
        IEngine engine = (IEngine) clz;
        engine.init(this);
        engine.service();
    }

    private String getEngineName (){
        HashMap<String,HashMap> yamlMap = ReadYaml.getYamlHash();
        HashMap<String,HashMap> serverMap = (HashMap) yamlMap.get(serverID);
        //System.out.println(serverMap);
        HashMap<String,HashMap> enginMap = (HashMap)serverMap.get("engine");
        HashMap<String,String> appMap = enginMap.get("app");
        appMap.get("name");
        return appMap.get("engineClass");
    }
}
