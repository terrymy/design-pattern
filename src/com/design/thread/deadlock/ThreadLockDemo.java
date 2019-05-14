package com.design.thread.deadlock;

import java.util.Vector;

public class ThreadLockDemo {

    private static int conut;

    /**
     * 生产
     */
    public void produce(){
        synchronized (this){
            for(int i=0;i<100;i++){
                conut++;
            }
        }
    }

    /**
     * 消费
     */
    public void consume(){
        for(int i=0;i<100;i++){
            synchronized (this) {
                conut++;
            }
        }
    }

    /**
     * 质量管控
     */
    public void control(){
        Vector<Integer> vector = new Vector<>();
        for(int i=0;i<100;i++){
            vector.add(i);
        }
    }

    public synchronized void run01(){
        this.produce();
        this.control();
        this.consume();
    }

    public void run02(){
        this.produce();
        synchronized (this){
            this.control();
        }
        this.consume();
    }
}
