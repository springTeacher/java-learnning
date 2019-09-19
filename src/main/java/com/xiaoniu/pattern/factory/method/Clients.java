package com.xiaoniu.pattern.factory.method;

import com.xiaoniu.pattern.factory.simple.RouJiaMo;
import com.xiaoniu.pattern.factory.simple.RouJiaMoFactory;
import com.xiaoniu.pattern.factory.simple.RouJiaMoStore;
import com.xiaoniu.pattern.factory.simple.SimpleRouJiaMoFactory;

/**
 * 客户端
 *
 *
 *
 * 我们的设想是根据肉夹馍的类型生产不同的肉夹馍，
 * 生产不同种类的肉夹馍跟商店解耦，商店只负责卖肉夹馍。
 *
 * 解决方案：构建一个生产肉夹馍的工厂
 *
 * @author lihoujing
 * @date 2019/9/11 18:21
 */
public class Clients {


    public static void main(String[] args) {

        RouJiaMoFactory factory = new SimpleRouJiaMoFactory();
        RouJiaMoStore store = new RouJiaMoStore(factory);

        RouJiaMo rouJiaMo = store.sellRouJiaMo("tian");
        System.out.println(rouJiaMo.getName());
    }

}
