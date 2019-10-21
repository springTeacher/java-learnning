package com.xiaoniu.jdk;

/**
 * @author lihoujing
 * @date 2019/10/16 10:06
 */
public class BinaryTest {
    static final int HASH_BITS = 0x7fffffff;

    public static void main(String[] args) {

        int h = "1wrewrtwer".hashCode();
        System.out.println(h);
        int result =  (h ^ (h >>> 16)) & HASH_BITS;

        System.out.println(result);



    }





    public static String toBinary(int num){
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num = num / 2;
        }
        return str;
    }

}
