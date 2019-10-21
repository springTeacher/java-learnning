package com.web.bo;

import java.io.Serializable;

/**
 * @author lihoujing
 * @date 2019/10/21 14:34
 */

public class HelloBO implements Serializable {

    private static final long serialVersionUID = -5376828872106650235L;


    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;


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
}
