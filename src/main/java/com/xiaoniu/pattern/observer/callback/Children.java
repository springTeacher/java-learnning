package com.xiaoniu.pattern.observer.callback;

/**
 * @author lhj
 * @date 2019/12/13 10:26
 */
public class Children {

    private Father father;

    public Children(Father father){
        this.father = father;
    }


    void doHomeWork(){
        father.onCall();
    }
}
