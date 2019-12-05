package com.xiaoniu.pattern.strategy.v2;

import com.xiaoniu.pattern.strategy.IOrderService;
import com.xiaoniu.pattern.strategy.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhj
 * @date 2019/12/2 9:39
 */
@Service
public class OrderServiceV2Impl implements IOrderService {



    @Autowired
    private HandleContext handleContext;

    @Override
    public String handle(OrderDTO orderDTO) {
        AbstractHandle handle = handleContext.getInstance(orderDTO.getType());
        return handle.handle(orderDTO);
    }
}
