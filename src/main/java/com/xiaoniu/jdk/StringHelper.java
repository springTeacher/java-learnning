package com.xiaoniu.jdk;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 字符串帮助类
 *
 * @author lihoujing
 * @date 2019/10/9 16:00
 */
public class StringHelper {



    /**
     * 判断目标字符串是否包含自定字符串
     *
     * @param target 目标字符串
     * @param key 指定字符串
     * @return boolean
     */
    public static boolean isContains(String target, String key){

        if(target == null || key == null || target.length() < key.length()){
            return false;
        }

        for (int i = 0; i <= target.length()-key.length(); i++){
            if(target.substring(i, i + key.length()).equals(key)){
                return true;
            }
        }

        return false;
    }








    /**
     * 比较两个int类型的值大小
     *
     * @param x
     * @param y
     * @return
     */
    public static int compare(int x, int y){
        return Integer.compare(x, y);
    }


    /**
     * 获取数组中的最小值
     * 该数组实现类Number
     * 并且重写了Comparable的方法
     *
     * @param values 待处理的数组
     * @param <T> 泛型
     * @return
     */
    public static <T extends Number & Comparable<T>> T min(T[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        T min = values[0];

        for (int i = 1; i < values.length; i++){
            if(min.compareTo(values[i])>0){
                min = values[i];
            }
        }

        return min;
    }


    public static <T extends Number & Comparable<T>> T minIterator(T[] values){
        if(values == null || values.length == 0){
            return null;
        }

        List<T> list = Arrays.asList(values);
        Iterator<T> iterator = list.iterator();

        T min = iterator.next();

        while (iterator.hasNext()){
            T next = iterator.next();
            if(min.compareTo(next) > 0){
                min = next;
            }
        }
        return min;


    }



    public static void main(String[] args) {
        Integer[] integers = {1,4,76,2,5,8,8,9,23,-23};
        Integer min = Collections.max(Arrays.asList(integers));

        System.out.println(min);





    }





}
