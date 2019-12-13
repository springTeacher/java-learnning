package com.xiaoniu.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者的update方法是一个回调方法
 *
 * @author lhj
 * @date 2019/11/29 11:07
 */
public class Student implements Observer {


    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        introduce((String)arg);
    }

    public void introduce(String teacherName) {
        System.out.println(teacherName + "老师你好，" + "我的名字叫" + name);
    }
}
