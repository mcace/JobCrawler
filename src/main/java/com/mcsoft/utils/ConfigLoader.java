package com.mcsoft.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置读取工具
 * Created by Mc on 2017/12/7.
 */
public class ConfigLoader {
    private static final String LAGOU_HEADER = "headers.properties";

    public static Map<String, String> loadLagouHeaders() {
        return loadConfig(LAGOU_HEADER);
    }

    public static Map<String, String> loadConfig(String fileName) {
        Map<String, String> configMap = new HashMap<>();
        if (null == fileName || fileName.equals("")) {
            return configMap;
        }
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File file = new File(classpath + File.separator + fileName);
        if (!file.exists()) {
            return configMap;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                int splitLine = line.indexOf("=");
                if (-1 == splitLine) {
                    continue;
                }
                configMap.put(line.substring(0, splitLine), line.substring(splitLine + 1, line.length()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configMap;
    }
}
