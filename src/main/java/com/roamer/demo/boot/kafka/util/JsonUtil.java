package com.roamer.demo.boot.kafka.util;

import com.google.gson.Gson;

/**
 * JSON 工具类
 *
 * @author roamer
 * @version v1.0
 * @date 2020/10/18 00:00
 */
public final class JsonUtil {
    private JsonUtil() {
    }


    private static final Gson GSON = new Gson();


    public static String toJson(Object o) {
        return GSON.toJson(o);
    }

}
