package com.xiaoniu.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author lhj
 * @date 2019/12/2 9:30
 */
public class OrderDTO {


    /**
     * 订单编号
     */
    private String code;


    /**
     * 价格
     */
    private BigDecimal price;


    /**
     * 订单类型：1-普通订单，2-团购订单，3-促销订单
     */
    private String type;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "code='" + code + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
