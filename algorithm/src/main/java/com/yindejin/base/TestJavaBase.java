package com.yindejin.base;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author: YDJ
 * @Date: 2020/2/13
 * @Description:
 */
public class TestJavaBase {

    public static void main(String[] args) {
        LinkedHashMap hashMap  = new LinkedHashMap();
        hashMap.put("test","test");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("test", "test");

        CountDownLatch countDownLatch = null;
        countDownLatch.countDown();

    }
}
