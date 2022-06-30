package com.jdk8.demo.entity;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: ZhengJinxu
 * @Date: 2021/10/24 20:22
 */
@Data
public class User {


    private String userName;

    private String passWord;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        Boolean flag = Objects.equals(userName, user.userName) &&
                Objects.equals(passWord, user.passWord);
        return flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passWord, userName);
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }


}
