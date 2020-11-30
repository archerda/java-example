package com.github.archerda.json.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author luohuida
 */
public class JsonAndJsonString {

    public static void main(String[] args) {
        User user = new User(20, "archer", new Class("六年级3班"));
        Object json = JSON.toJSON(user);
        String jsonString = JSON.toJSONString(user);
        System.out.println(1);
    }

    private static class User {
        private int age;
        private String name;
        private Class aClass;

        public User(int age, String name, Class aClass) {
            this.age = age;
            this.name = name;
            this.aClass = aClass;
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

        public Class getaClass() {
            return aClass;
        }

        public void setaClass(Class aClass) {
            this.aClass = aClass;
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
