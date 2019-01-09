package com.github.archerda.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create by archerda on 2016/11/29
 */
public class GroupTest {

    private static class User {
        public String name;
        public Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        new GroupTest().test();
    }

    private void test() {
        List<User> users = new ArrayList<>();
        users.add(new User("luohuida", 23));
        users.add(new User("luohuida2", 24));
        users.add(new User("luohuida2", 23));

        Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(map);
    }
}
