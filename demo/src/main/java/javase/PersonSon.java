package javase;

import java.util.Objects;

/**
 * @Author: ZhengJinxu
 * @Date: 2022/2/26 15:07
 */
public class PersonSon extends Person{
    private  String name;
    private int age;
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final PersonSon person = (PersonSon) o;
        return this.age == person.age && Objects.equals(this.name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }

    public PersonSon() {
    }

    public PersonSon(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
