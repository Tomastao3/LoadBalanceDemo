package java.com.demo.util;


import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Paths;
import java.util.Date;

public class RecommendRegularFactory {

    Date lastModifiedTime;

    RecommendRegular recommendRegular;

    /**
     * 先检测外部文件是否存在，如果存在则加载外部文件，如果不存在则加载resource中的文件。
     * 外部文件如果有修改则重新加载，没有修改，则直接返回。
     * @return
     */
    public RecommendRegular getRecommendRegular(){
        File configFile = Paths.get("classpath:application.yml").toFile();
        if(configFile.exists()){   //加载外部配置文件
            if(recommendRegular != null && lastModifiedTime != null && lastModifiedTime.getTime() == configFile.lastModified()){
                return recommendRegular;
            }
            try {
                FileInputStream ymlInputStream = new FileInputStream(configFile);
//            RecommendRegular recommendRegular = new Yaml().loadAs(RecommendDailyServiceImpl.class.getResourceAsStream("/recommend-regular.yml"), RecommendRegular.class);
                RecommendRegular recommendRegular = new Yaml().loadAs(ymlInputStream, RecommendRegular.class);
                ymlInputStream.close();
                this.recommendRegular = recommendRegular;
                this.lastModifiedTime = new Date(configFile.lastModified());
                return recommendRegular;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
