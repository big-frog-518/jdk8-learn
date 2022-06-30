package com.jdk8.demo.completablefuture;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int i = climbStairs(4);
        System.out.println(i);
    }
    private static HashMap<Integer,Integer> dp = new HashMap<>();
    public static int climbStairs(int n) {
        if (n==1||n==2){
            return n;

        }
        if (null!=dp.get(n)){
            return dp.get(n);
        }else {
            int result = climbStairs(n-1)+ climbStairs(n-2);
            dp.put(n,result);
            return result;
        }


    }

}
