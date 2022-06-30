package huaweiod;

import java.util.*;
import java.util.stream.Collectors;

public class Test5 {
    /**
     * 【按身高和体重排队】
     * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
     * 输入描述:
     * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
     * 输出描述:
     * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始
     * 示例1：
     * 输入
     * 4
     * 100 100 120 130
     * 40 30 60 50
     * 输出
     * 2 1 3 4
     * 说明
     * 输出的第一个数字2表示此人原始编号为2，即身高为100，体重为30的这个人。由于他和编号为1的人身高一样，但体重更轻，因此要排在1前面。
     * 示例2：
     * 输入
     * 3
     * 90 110 90
     * 45 60 45
     * 输出
     * 1 3 2
     * 说明
     * 1和3的身高体重都相同，需要按照原有位置关系让1排在3前面，而不是3 1 2
     * ————————————————
     * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/csfun1/article/details/124362254
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] high = sc.nextLine().split(" ");
        String[] weight = sc.nextLine().split(" ");
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            playerList.add(new Player(i+1,Integer.parseInt(high[i]),Integer.parseInt(weight[i])));
        }
//        Collections.sort(playerList);
        playerList = playerList.stream().sorted(Comparator.comparing(Player::getHigh).thenComparing(Player::getWeight).thenComparing(Player::getIdx)).collect(Collectors.toList());
        for (int i = 0; i < playerList.size(); i++) {
            System.out.print(playerList.get(i).idx+" ");
        }
    }

    static class Player{
        private int idx;
        private int high;

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        private int weight;

        public Player(int idx, int high, int weight) {
            this.idx = idx;
            this.high = high;
            this.weight = weight;
        }

//        @Override
//        public int compareTo(Player ply) {
//            if (ply.high > this.high){
//                return -1;
//            }
//            if (ply.weight > this.weight){
//                return -1;
//            }
//            if (ply.idx > this.idx){
//                return -1;
//            }
//            return 0;
//        }
    }
}
