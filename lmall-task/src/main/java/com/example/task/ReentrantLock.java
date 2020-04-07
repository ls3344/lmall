package com.example.task;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author long
 * @date 2020/3/31
 */
public class ReentrantLock {

    Lock lock=new java.util.concurrent.locks.ReentrantLock();


    void m1(){
        try {
            lock.lock();
            for(int i=0;i<10;i++){
                System.out.println("i="+i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        System.out.println("m2......开始");
        lock.lock();
    }

    public static void main(String[] args) {
        ReentrantLock r1=new ReentrantLock();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }


}
