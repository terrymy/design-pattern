package com.design.thread.deadlock;
public class DeathThreadDemo {
    public static void main(String[] args) {
        DeadLock deadLock0 = new DeadLock(0);
        DeadLock deadLock1 = new DeadLock(1);
        new Thread(deadLock0).start();
        new Thread(deadLock1).start();
    }
}
class DeadLock implements Runnable{
    private int value;
    private String end = "END";
    private static Object obj0 = new Object();
    private static Object obj1 = new Object();
    public DeadLock(int value){
        this.value = value;
    }
    public void run() {
        if(value == 0){
            synchronized(this){
                for (int i = 0; i < 1000; i++) {
                    System.out.println("deadLock0:"+i);
                }
                synchronized(obj0){
                    System.out.println("deadLock1:"+end);
                }
            }
        }
        if(value == 1){
            synchronized(obj0){
                for (int i = 0; i < 1000; i++) {
                    System.out.println("deadLock1:"+i);
                }
                synchronized(this){
                    System.out.println("deadLock0:"+end);
                }
            }
        }
    }
}