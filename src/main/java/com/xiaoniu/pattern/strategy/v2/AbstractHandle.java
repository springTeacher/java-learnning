package com.xiaoniu.pattern.strategy.v2;

import com.xiaoniu.pattern.strategy.OrderDTO;

/**
 * @author lhj
 * @date 2019/12/2 9:44
 */
public abstract class AbstractHandle {


    /**
     * 根据不同的订单类型，做不同的处理
     *
     * @param orderDTO
     * @return
     */
    public abstract String handle(OrderDTO orderDTO);

}
