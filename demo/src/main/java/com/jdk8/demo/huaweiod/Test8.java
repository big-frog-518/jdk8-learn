package com.jdk8.demo.huaweiod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test8 {
    /**
     * 【比赛评分】
     * 一个有N个选手参加比赛，选手编号为1~N（3<=N<=100），有M（3<=M<=10）个评委对选手进行打分。打分规则为每个评委对选手打分，最高分10分，最低分1分。
     * 请计算得分最多的3位选手的编号。如果得分相同，则得分高分值最多的选手排名靠前(10分数量相同，则比较9分的数量，以此类推，用例中不会出现多个选手得分完全相同的情况)。
     * 输入描述:
     * 第一行为半角逗号分割的两个正整数，第一个数字表示M（3<=M<=10）个评委，第二个数字表示N（3<=N<=100）个选手。
     * 第2到M+1行是半角逗号分割的整数序列，表示评委为每个选手的打分，0号下标数字表示1号选手分数，1号下标数字表示2号选手分数，依次类推。
     * 输出描述:
     * 选手前3名的编号。
     * 注：若输入为异常，输出-1，如M、N、打分不在范围内。
     * 示例1：
     * 输入
     * 4,5
     * 10,6,9,7,6
     * 9,10,6,7,5
     * 8,10,6,5,10
     * 9,10,8,4,9
     * 输出
     * 2,1,5
     * 说明
     * 第一行代表有4个评委，5个选手参加比赛
     * 矩阵代表是4*5，每个数字是选手的编号，每一行代表一个评委对选手的打分排序，
     * 2号选手得分36分排第1，1号选手36分排第2，5号选手30分(2号10分值有3个，1号10分值只有1个，所以2号排第一)
     * 示例2：
     * 输入
     * 2,5
     * 7,3,5,4,2
     * 8,5,4,4,3
     * 输出
     * -1
     * 说明：只有2个评委，要求最少为3个评委
     * 示例3：
     * 输入
     * 4,2
     * 8,5
     * 5,6
     * 10,4
     * 8,9
     * 输出
     * -1
     * 说明：只有2名选手参加，要求最少为3名
     * 示例4：
     * 输入
     * 4,5
     * 11,6,9,7,8
     * 9,10,6,7,8
     * 8,10,6,9,7
     * 9,10,8,6,7
     * 输出
     * -1
     * 说明：第一个评委给第一个选手打分11，无效分数
     * ————————————————
     * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/csfun1/article/details/124362254
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(",");
        int ma = Integer.parseInt(num[0]);//教练
        int no = Integer.parseInt(num[1]);//选手
        if (ma > 10 || ma < 3 || no > 100 || no < 3) {
            System.out.println(-1);
            return;
        }
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < ma; i++) {
            list.add(sc.nextLine().split(","));
        }
        //收集选手信息
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < no; i++) {//第i个选手
            int total = 0;
            List<Integer> listScore = new ArrayList<>();
            for (int j = 0; j < ma; j++) {//第j个裁判
                String[] strings = list.get(j);
                int score = Integer.parseInt(strings[i]);
                if (score < 0 || score > 10) {
                    System.out.println(-1);
                    return;
                }
                listScore.add(score);
                total += score;
            }
            players.add(new Player(i, total, listScore));
        }
        //比较选手分数
        Collections.sort(players);
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                System.out.println(players.get(i).idx + 1);
            } else {
                System.out.print(players.get(i).idx + 1 + ",");
            }
        }

    }

    static class Player implements Comparable<Player> {
        private int idx;
        private int total;
        private List<Integer> scores;

        public Player(int idx, int total, List<Integer> scores) {
            this.idx = idx;
            this.total = total;
            this.scores = scores;
        }

        private int checkCount(List<Integer> list, int count) {
            int cou = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == count) {
                    cou++;
                }
            }
            return cou;
        }

        @Override
        public int compareTo(Player ply) {
            //先比较总分
            if (ply.total < this.total) {
                return -1;
            } else if (ply.total > this.total) {
                return 1;
            } else {
                //后比较最高分的数量
                List<Integer> scPly = ply.scores;
                List<Integer> scores = this.scores;
                for (int i = 10; i > 0; i--) {
                    int ipl = checkCount(scPly, i);
                    int ith = checkCount(scores, i);
                    if (ipl < ith) {
                        return -1;
                    }
                }
            }
            return 0;
        }
    }
}
