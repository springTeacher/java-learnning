package com.xiaoniu.pattern.observer.callback.event;

/**
 * @author lhj
 * @date 2019/12/13 11:04
 */
public class Test {

    public static void main(String[] args) {
        Notifier notifier = new Notifier ();
        CallListener a = new CallListener("Listener A");
        CallListener b = new CallListener("Listener B");
        // 给通知者注册监听者，并直接启动通知
        notifier.regist(a);
        notifier.regist(b);
        // 此处回调监听Listener的processEvent处理事件
        notifier.doWork();
    }
}
