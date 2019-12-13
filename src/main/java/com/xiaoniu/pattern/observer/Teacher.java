package com.xiaoniu.pattern.observer;

import java.util.Observable;

/**
 * 被观察者
 *
 * 被观察者持有观察者的实例
 *
 * @author lhj
 * @date 2019/11/29 11:06
 */
public class Teacher extends Observable {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }


    public void introduce(){
        System.out.println("我是:"+ name + "老师！");
        super.setChanged();
        super.notifyObservers(name);
    }



}
