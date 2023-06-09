package com.jdk8.demo.completablefuture;


import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZhengJinxu
 * @Date: 2021/12/26 21:25
 */

public class completablefuture {

    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });

        future.get();
    }

    //有返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("time = "+time);
    }

    public static void main(String[] args) {
        ArrayList<Object> strings = new ArrayList<>();
        strings.add("sadasd");
        strings.add("asdadv");
        strings.add("asdkjhda");
        System.out.println(Strings.join(strings,','));
    }

}
