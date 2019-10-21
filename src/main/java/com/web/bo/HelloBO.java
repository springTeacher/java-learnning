package com.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lihoujing
 * @date 2019/10/21 14:34
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

    private Date date;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
