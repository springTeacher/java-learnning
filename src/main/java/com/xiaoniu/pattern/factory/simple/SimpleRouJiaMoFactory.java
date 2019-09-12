package com.xiaoniu.pattern.factory.simple;

/**
 * @author lihoujing
 * @date 2019/9/11 18:26
 */
public class SimpleRouJiaMoFactory implements RouJiaMoFactory{


    @Override
    public RouJiaMo createRouJiaMo(String type) {
        RouJiaMo rouJiaMo = null;
        if("suan".equals(type)){
            rouJiaMo = new SuanRouJiaMo();
        }else if("tian".equals(type)){
            rouJiaMo = new TianRouJiaMo();
        }else {
            rouJiaMo = new DefaultRouJiaMo();
        }
        return rouJiaMo;
    }
}
