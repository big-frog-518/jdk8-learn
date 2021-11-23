package com.jdk8.demo.optional;

import java.util.Objects;
import java.util.Optional;

/**
 * @Author: ZhengJinxu
 * @Date: 2021/11/23 23:19
 */
public class TestOptional {

    public static String getErrorInsuranceName(UserOptional user) {
        return user.getCar().getInsurance().getInsuranceName();
    }

    public static String getInsuranceName(UserOptional user) {
        if (user != null) {
            Car car = user.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getInsuranceName();
                }
            }
        }
        return "not found";
    }

    public static String getInsuranceNameBak(UserOptional user) {
        if (user == null) {
            return "not found";
        }
        if (user.getCar() == null) {
            return "not found";
        }
        if (user.getCar().getInsurance() == null) {
            return "not found";
        }
        return user.getCar().getInsurance().getInsuranceName();
    }

    public static void main(String[] args) {

        UserOptional user = new UserOptional();
        Car car = new Car();
        car.setCarName("red car");
        Insurance insurance = new Insurance();
        insurance.setInsuranceName("speed protected");
        car.setInsurance(insurance);
        user.setCar(car);
        user.setUserName("张三");

        //System.out.println(getInsuranceNameBak(user));

        UserOptional optional = Optional.ofNullable(user).get();
        System.out.println(optional.getUserName());

        UserOptional user1 = new UserOptional();
        UserOptional user2 = Optional.ofNullable(user1).orElse(orElseGetUser());
        UserOptional user3 = Optional.ofNullable(user1).orElseGet(() -> orElseGetUser());

        UserOptional userOfNull = null;
        //User user4 = Optional.ofNullable(userOfNull).orElseThrow(() -> new ArrayIndexOutOfBoundsException());

        Optional.ofNullable(userOfNull).ifPresent(u -> System.out.println(u.getUserName() + "If Present"));
        String userName = Optional.ofNullable(user1).map(x -> x.getUserName() + " Get By Map").get();
        System.out.println(userName);

        UserOptional userHaveHouse = new UserOptional();
        userHaveHouse.setUserName("wangwu");
        House house = new House();
        house.setAddress("Part Block Three");
        userHaveHouse.setHouse(Optional.of(house));

        Optional<House> oh = Optional.ofNullable(userHaveHouse).map(uhh -> uhh.getHouse()).get();
        House house1 = Optional.ofNullable(userHaveHouse).flatMap(uhh -> uhh.getHouse()).get();
        System.out.println(house1.getAddress());

        Optional.ofNullable(userHaveHouse).filter(uhh -> Objects.equals(uhh.getUserName(), "wangwu"))
                .flatMap(uhh -> uhh.getHouse())
                .ifPresent(uhh -> System.out.println(uhh.getAddress() + " Plus By Filter"));

        // 尝试获取用户的用户名称，不存在则返回默认值
        String userName1 = Optional.ofNullable(userOfNull).orElse(new UserOptional()).getUserName();
        System.out.println(userName1);

        // 尝试获取用户的carName，不存在则返回null
        String carName = Optional.ofNullable(user).map(u -> u.getCar()).map(c -> c.getCarName()).orElse(null);
        System.out.println(carName);

        // 用户名存在的时候则转为大写
        Optional.ofNullable(user).map(u -> u.getUserName()).ifPresent(userName2 -> System.out.println(userName2.toUpperCase()));

        // 过滤出来用户名称是张三的用户
        Optional.ofNullable(user).filter(u -> Objects.equals(u.getUserName(), "张三"))
                .map(u -> u.getUserName())
                .ifPresent(userName4 -> System.out.println(userName4 + "实战Test"));

        // 将张三的用户名称改成李四
        Optional.ofNullable(user).ifPresent(x -> {
            if (Objects.equals(x.getUserName(), "张三")) {
                x.setUserName("李四");
                System.out.println(x.getUserName());
            }
        });

        Optional.ofNullable(user).filter(u -> Objects.equals(u.getUserName(), "张三"))
                .ifPresent(x -> {
                    x.setUserName("李四");
                    System.out.println(x.getUserName() + "Test By Filter");
                });
    }

    public static UserOptional orElseGetUser() {
        UserOptional user = new UserOptional();
        user.setUserName("lisi");
        System.out.println(user.getUserName());
        return user;
    }
}
