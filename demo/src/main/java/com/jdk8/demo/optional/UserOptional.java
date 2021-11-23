package com.jdk8.demo.optional;

import java.util.Optional;

/**
 * @Author: ZhengJinxu
 * @Date: 2021/11/23 22:16
 */
public class UserOptional {

    private String userName;

    private Car car;

    private Optional<House> house;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Optional<House> getHouse() {
        return house;
    }

    public void setHouse(Optional<House> house) {
        this.house = house;
    }
}
