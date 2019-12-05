package com.xiaoniu.pattern.strategy;

/**
 * @author lhj
 * @date 2019/12/2 9:33
 */
public interface IOrderService {


    /**
     * 根据不同的订单类型做不同的处理
     *
     * @param orderDTO
     * @return
     */
    String handle(OrderDTO orderDTO);
}
