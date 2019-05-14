package com.design.creational.singleton;

import java.util.concurrent.ThreadPoolExecutor;

public class Singleton {

    /**
     * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载，volatile防止指令重排序，在instance未被new时就被返回
     */
    private static volatile Singleton instance = null;

    // 线程池对象
    private ThreadPoolExecutor threadPoolExecutor;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }
}
