package javase;

import lombok.Data;

import java.util.Objects;

/**
 * @Author: ZhengJinxu
 * @Date: 2022/2/26 14:59
 */
@Data
public class Person implements Runnable{
    private  String name;
    private int age;
    public void method(){
        System.out.println(name);
    }

}


