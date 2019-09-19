package com.xiaoniu.pattern.builder;

/**
 * 非静态内部类编译之后，持有一个外部类的引用；
 * 今天内部类却没有，完全独立。
 *
 * 嵌套的意思，是我完全可以独立存在，但我就是想借你的壳用一下，隐藏一下我自己。
 * 它是一个独立的类，完全是形式上的“内部”，和外部类没有本质上“内外”的关系。
 *
 * @author lihoujing
 * @date 2019/9/16 10:24
 */
public class OutClass {

    private OutClass(){
        System.out.println("外部类 构造 ");
    }


    public void outMethod(){
        System.out.println("outMethod");
    }


    public static void main(String[] args) {
        OutClass.InnerClass innerClass = new OutClass().new InnerClass();
        innerClass.innerMethod();
    }





    class InnerClass{

        private InnerClass(){
            System.out.println("InnerClass 构造");
        }

        public void innerMethod(){
            // 内部类可以直接访问外部类成员，原因在于隐式持有了一个外部类引用
            outMethod();
            // Outer.this 就是内部类隐式持有的外部类引用
            OutClass.this.outMethod();
            System.out.println(OutClass.this);
        }

    }
}
