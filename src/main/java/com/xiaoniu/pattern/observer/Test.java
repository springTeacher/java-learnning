package com.xiaoniu.pattern.observer;

/**
 * @author lhj
 * @date 2019/11/29 11:12
 */
public class Test {


    public static void main(String[] args) {

        Teacher tony = new Teacher("Tony");

        Student studentA = new Student("A");
        Student studentB = new Student("B");
        Student studentC = new Student("C");

        tony.addObserver(studentA);
        tony.addObserver(studentB);
        tony.addObserver(studentC);

        tony.introduce();

        int i = tony.countObservers();
        System.out.println(i);


    }
}
