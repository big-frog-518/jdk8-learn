package com.jdk8.demo.huaweiod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author admin
 */
public class Test6 {
    /**
     * 【按索引范围翻转文章片段】
     * 输入一个英文文章片段，翻转指定区间的单词顺序，标点符号和普通字母一样处理。例如输入字符串"I am a developer. “，区间[0,3]，则输出"developer. a am I"
     * String reverseWords(String s, int start, int end)
     * 输入描述:
     * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，第二个参数为翻转起始单词下标(下标从0开始)，第三个参数为结束单词下标。
     * 输出描述:
     * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出
     * 示例1：
     * 输入
     * I am a developer.
     * 1
     * 2
     * 输出
     * I a am developer.
     * 示例2：
     * 输入
     * hello world!
     * 0
     * 1
     * 输出
     * world! hello
     * 说明
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例3：
     * 输入
     * I am a developer.
     * 0
     * 3
     * 输出
     * developer. a am I
     * 说明
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * 示例4：
     * 输入
     * Hello!
     * 0
     * 3
     * 输出
     * EMPTY
     * 说明
     * 指定翻转区间只有一个单词或无有效单词，则统一输出"EMPTY"
     * ————————————————
     * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/csfun1/article/details/124362254
     */

    private static String[] content;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] num = sc.nextLine().split(" ");
        System.out.println(reverseWords(input, Integer.parseInt(num[0]), Integer.parseInt(num[1])));
    }
    private static String reverseWords(String str,int start,int end){
        String[] content = str.split(" ");
        while (start < end){
            String temp = "";
            temp = content[end];
            content[end] = content[start];
            content[start] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            sb.append(content[i]);
            if (i+1 < content.length){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
