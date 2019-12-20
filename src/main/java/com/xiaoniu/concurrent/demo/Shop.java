package com.xiaoniu.concurrent.demo;

import java.util.Random;

/**
 * @author lhj
 * @date 2019/12/19 14:06
 */
public class Shop {

    private String name;

    public Shop(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(String product)  {
        //查询商品的数据库，或链接其他外部服务获取折扣
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
