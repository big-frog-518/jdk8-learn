package com.jdk8.demo.study;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @Author: ZhengJinxu
 * @Date: 2022/7/4 19:01
 */
public class Test1 {
    public static void main(String[] args) {
        long milli = LocalDateTime.now().plusYears(10).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.currentTimeMillis();
        System.out.println(milli);
    }
}
