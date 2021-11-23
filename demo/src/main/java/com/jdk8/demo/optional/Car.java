package com.jdk8.demo.optional;

/**
 * @Author: ZhengJinxu
 * @Date: 2021/11/23 22:09
 */
public class Car {
    private String carName;

    private Insurance insurance;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
