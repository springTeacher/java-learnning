package com.xiaoniu.pattern.factory.method;

/**
 * 肉夹馍产品
 *
 * @author lihoujing
 * @date 2019/9/11 18:21
 */
public class RouJiaMo {

    private String name;


    /**
     * 准备工作
     */
    public void prepare(){
        System.out.println("揉面-剁肉-完成准备工作");
    }

    /**
     * 秘制设备-烘烤2分钟
     */
    public void fire(){
        System.out.println("肉夹馍-专用设备-烘烤");
    }

    /**
     * 使用你们的专用袋-包装
     */
    public void pack(){
        System.out.println("肉夹馍-专用袋-包装");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RouJiaMo{" +
                "name='" + name + '\'' +
                '}';
    }
}
