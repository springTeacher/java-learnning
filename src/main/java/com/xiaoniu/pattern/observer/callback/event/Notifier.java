package com.xiaoniu.pattern.observer.callback.event;

import java.util.ArrayList;
import java.util.List;

/**
 * 传入包含回调函数的对象
 *
 * @author lhj
 * @date 2019/12/13 11:03
 */
public class Notifier {

    private List<CallListener> callListenerList=new ArrayList<>();

    public void regist(CallListener callListener){
        callListenerList.add(callListener);
    }
    public void doWork(){
        for(CallListener callListener: callListenerList) {
            //触发回调函数
            callListener.processEvent("sample event");
        }
    }
}
