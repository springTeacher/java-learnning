package com.xiaoniu.pattern.factory.simple;

/**
 * 肉夹馍商店
 *
 * @author lihoujing
 * @date 2019/9/11 18:21
 */
public class RouJiaMoStore {


    private RouJiaMoFactory rouJiaMoFactory;


    public RouJiaMoStore(RouJiaMoFactory rouJiaMoFactory){
        this.rouJiaMoFactory = rouJiaMoFactory;
    }

    public RouJiaMo sellRouJiaMo(String type){
        RouJiaMo rouJiaMo = rouJiaMoFactory.createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }




}
