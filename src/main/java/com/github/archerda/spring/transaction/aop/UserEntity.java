package com.github.archerda.spring.transaction.aop;

/**
 * 用户实体
 *
 * @author archerda
 * @date 2018/7/17
 */
public class UserEntity {

    private Long id;
    private String name;
    private Integer age;

    public UserEntity() {
        super();
    }

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
