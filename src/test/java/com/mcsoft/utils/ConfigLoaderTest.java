package com.mcsoft.utils;

import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/7.
 */
public class ConfigLoaderTest {
    @Test
    public void loadConfig() throws Exception {
        Map<String, String> map = ConfigLoader.loadLagouAjaxHeaders();
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}