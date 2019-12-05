package com.xiaoniu.pattern.strategy;

import org.springframework.stereotype.Service;

/**
 * @author lhj
 * @date 2019/12/2 9:35
 */
@Service
public class OrderServiceTraditionalImpl implements IOrderService {


    @Override
    public String handle(OrderDTO orderDTO) {
        if("1".equals(orderDTO.getType())){
            return "普通订单处理";
        }else if("2".equals(orderDTO.getType())){
            return "团购订单处理";
        }else if("3".equals(orderDTO.getType())){
            return "促销订单处理";
        }
        return null;
    }
}
