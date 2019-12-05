package com.xiaoniu.pattern.strategy.v2.handle;

import com.xiaoniu.pattern.strategy.OrderDTO;
import com.xiaoniu.pattern.strategy.v2.AbstractHandle;
import com.xiaoniu.pattern.strategy.v2.HandleType;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/12/2 10:17
 */
@Component
@HandleType("3")
public class PromotionHandle extends AbstractHandle {
    @Override
    public String handle(OrderDTO orderDTO) {
        return "促销订单处理V2";
    }
}
