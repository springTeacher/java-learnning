package com.xiaoniu.atomic;

/**
 * CopyOnWriteArrayList 写写互斥，add() 方法通过ReentrantLock实现线程安全.
 *
 *
 * @author lhj
 * @date 2019/12/10 16:33
 */
public class MyCopyOnWriteArrayListTest {


    private Object[] arrays;



    public static void main(String[] args) {

    }

    public Object get(int index){
        return get(getArrays(), index);
    }


    public Object get(Object[] arrays, int index){
        return arrays[index];
    }


    public Object[] getArrays() {
        return arrays;
    }

    public void setArrays(Object[] arrays) {
        this.arrays = arrays;
    }
}
