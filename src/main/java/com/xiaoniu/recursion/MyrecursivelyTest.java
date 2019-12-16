package com.xiaoniu.recursion;

/**
 * @author lhj
 * @date 2019/12/16 9:42
 */
public class MyrecursivelyTest {


    public static void main(String[] args) {


        int sum = sum(6553);
        System.out.println(sum);


    }




    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        return n + sum(n-1);
    }

}
