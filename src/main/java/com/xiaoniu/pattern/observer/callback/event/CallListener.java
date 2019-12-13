package com.xiaoniu.pattern.observer.callback.event;

/**
 * 实现接口的回调方法
 *
 * @author lhj
 * @date 2019/12/13 11:01
 */
public class CallListener implements Event {



    private String name;
    public CallListener(String name) {
        // 新建一个事件通知者对象，并把自己传递给它
        this.name= name;
    }
    /**
     *  实现事件发生时，实际处理事件的方法
     */
    @Override
    public void processEvent(String source) {
        // 监听到事件发生了，进行处理

        System.out.println(source);
    }
}
