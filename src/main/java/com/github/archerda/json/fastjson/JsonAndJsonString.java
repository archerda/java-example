package com.github.archerda.json.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author luohuida
 */
public class JsonAndJsonString {

    public static void main(String[] args) {
        User user = new User(20, "archer");
        Object json = JSON.toJSON(user);
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        String a = "{\"name\":\"archer2\", \"name2\":\"archer=3\"}";
        User user1 = JSON.parseObject(a, User.class);
        System.out.println(user1);
    }

    public static class User {
        private int age = 1;
        private String name;


        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
        }
    }

    private static class Class {
        private String className;

        public Class(String className) {
            this.className = className;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }
}
