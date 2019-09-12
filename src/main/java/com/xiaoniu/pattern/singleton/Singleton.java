package com.xiaoniu.pattern.singleton;

/**
 * @author lihoujing
 * @date 2019/9/12 10:34
 */
public class Singleton {

    private Singleton(){

    }

    private enum HolderEnum{
        /**单类对象*/
        INSTANCE;

        private Singleton instance = null;

        HolderEnum(){
            instance = new Singleton();
        }

        public Singleton getInstance(){
            return instance;
        }
    }

    public static Singleton getInstance(){
        return HolderEnum.INSTANCE.getInstance();
    }

}
