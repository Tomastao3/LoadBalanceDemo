package com.demo.yaml;

import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;

public class ReadYaml {

    static Object yamlInfo = null;
    static boolean refresh = false;

    public static ConfInfo getYamlInfo(){
/*        if(yamlInfo == null)
            return yamlInfo;
        if(refresh = false){
            return yamlInfo;
        }*/
        File configFile = Paths.get("src\\application.yml").toFile();
        if(configFile.exists()){
            try {
                FileInputStream ymlInputStream = new FileInputStream(configFile);
                ConfInfo confInfo = (ConfInfo) new Yaml().loadAs(ymlInputStream, ConfInfo.class);
                ymlInputStream.close();
                return confInfo;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static HashMap<String,HashMap> getYamlHash(){

        File configFile = Paths.get("src\\application.yml").toFile();
        if(configFile.exists()){
            try {
                FileInputStream ymlInputStream = new FileInputStream(configFile);
                HashMap<String,HashMap> hashMap = (HashMap) new Yaml().loadAs(ymlInputStream, HashMap.class);
                ymlInputStream.close();
                return hashMap;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public static void setRefresh(boolean refresh) {
        ReadYaml.refresh = refresh;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
        //System.out.println(getYamlInfo());
        System.out.println(getYamlHash());
    }
}
