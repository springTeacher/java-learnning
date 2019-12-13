package com.xiaoniu.pattern.observer.callback.event;

/**
 * 接口，包含回调函数声明
 *
 * @author lhj
 * @date 2019/12/13 10:57
 */
public interface Event {

    void processEvent(String source);
}
