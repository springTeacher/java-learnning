package com.xiaoniu.jdk;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lihoujing
 * @date 2019/10/8 19:01
 */
public class ArrayUtils {



    public static int binarySearch(int[] a, int key){
        return binarySearch0(a, 0, a.length, key);
    }


    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key){
        int low = fromIndex;
        int high = toIndex -1;

        while (low <= high){
            int mid = low + high;
            int midVal = a[mid];

            if(midVal < key){
                low = mid + 1;
            }else if(midVal > key){
                high = mid - 1;
            }else {
                return mid;
            }
        }

        return -(low + 1);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 200000; i++) {
            list.add("list"+i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }
















}
