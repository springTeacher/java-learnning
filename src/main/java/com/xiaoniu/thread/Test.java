package com.xiaoniu.thread;

import java.math.BigDecimal;

/**
 * @author lihoujing
 * @date 2019/9/19 15:15
 */
public class Test {


    public static void main(String[] args) {

        Integer a = 300;
        Integer b = 300;
        System.out.println(a == b);
        System.out.println(a.equals(b));


        BigDecimal bigDecimal = BigDecimal.valueOf(34.2);
        bigDecimal.setScale(2,BigDecimal.ROUND_HALF_DOWN);

    }



}
