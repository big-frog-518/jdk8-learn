package com.jdk8.demo.completablefuture;

public class tset {
    public static void main(String[] args) {
        int m = 10;
        int[] A = new int[]{2,3,5,7};
        int[] V = new int[]{1,5,2,4};
        int result = tobage(A, V, m);
        System.out.println(result);
    }


    public  static int tobage(int[] A,int[]V,int m){
        int[][] dp=new int[A.length+1][m+1];
        for (int i=1;i<A.length+1;i++){
            for (int j=1;j<m+1;j++){
                if (j>=A[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-A[i-1]]+V[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[A.length][m];
    }
}
