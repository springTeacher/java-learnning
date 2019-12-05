package com.xiaoniu.pattern.strategy.v2.handle;

import com.xiaoniu.pattern.strategy.OrderDTO;
import com.xiaoniu.pattern.strategy.v2.AbstractHandle;
import com.xiaoniu.pattern.strategy.v2.HandleType;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/12/2 10:08
 */
@Component
@HandleType("1")
public class NormalHandle extends AbstractHandle {



    @Override
    public String handle(OrderDTO orderDTO) {
        return "普通订单处理V2";
    }
}
