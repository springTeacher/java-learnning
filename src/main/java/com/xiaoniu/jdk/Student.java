package com.xiaoniu.jdk;

/**
 * @author lihoujing
 * @date 2019/10/10 21:22
 */
public class Student {

    private String name;

    private Integer sex;


    public Student(String name, Integer sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
