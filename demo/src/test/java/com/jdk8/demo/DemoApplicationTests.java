package com.jdk8.demo;

import com.jdk8.demo.entity.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class DemoApplicationTests {
    /**
     * lambda练习
     */
    List<User> userList = new ArrayList<User>() {
            {
                add(new User("a", "b"));
                add(new User("a1", "b1"));
                add(new User("a222", "b2"));
                add(new User("a", "bb"));
                add(new User("a", "bbc"));
                add(new User("a3", "b1"));
                add(new User("a44", "b2"));
            }
        };

    @Test
    public void forEachTest() {
        System.out.println("forEach遍历方式一");
        userList.forEach(s -> System.out.print(s + " "));
        System.out.println("forEach遍历方式二");
        userList.forEach(System.out::println);
    }
    @Test
    public void threadTest() {
        // 继承Thread的形式
        new Thread(() -> System.out.println("我是线程的run方法"))
                .start();
        // 实现runable的形式
        Runnable r2 = () -> System.out.println("我也是线程的run方法");
        r2.run();
    }
    @Test
    public void sortTest() {
        String[] players = {"1", "3", "2", "0"};
        System.out.println("排序前");
        List<String> list = Arrays.asList(players);
        list.forEach(s -> System.out.print(s + " "));

        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("\n排序后");
        List<String> list1 = Arrays.asList(players);
        list1.forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void test() {
        User maxUser=userList.stream().max((p1,p2)->p1.getUserName().length()-p2.getUserName().length()).get();
        User minUser=userList.stream().min((p1,p2)->p1.getUserName().length()-p2.getUserName().length()).get();
        System.out.println(maxUser+" \n"+minUser);
    }

    /**
     * stream流
     */
    @Test
    public void toSetTest() {
        Set<String> setUser = userList.stream()
                .map(User::getUserName)
                .collect(Collectors.toSet());
        setUser.forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void toTreeSetTest() {
        TreeSet<String> treeSet = userList.stream()
                .map(User::getUserName)
                .collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void filterTest() {
        userList.stream()
                .filter(p -> p.getUserName().equals("a"))
                .limit(1)
                .forEach(p -> System.out.println(p.getPassWord() + " "));

        userList.stream()
                .filter(p -> p.getUserName().equals("a"))
                .forEach(p -> System.out.println(p.getPassWord() + " "));
    }
    @Test
    public void test222() {
        List<Integer> intNum= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) ;
        IntSummaryStatistics summaryStatistics=intNum.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(summaryStatistics.getCount()+" "+summaryStatistics.getAverage()+" "+summaryStatistics.getMax());
    }
}




