package com.example.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author long
 * @date 2020/3/16
 */
public class MyContainer {
    volatile List<Object> list=new ArrayList<>();

    public void add(Object o){
        list.add(o);
    }

    public int getSize(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer myContainer=new MyContainer();
        CountDownLatch countDownLatch=new CountDownLatch(1);

        new Thread(() ->{
            System.out.println("t2启动");
            if(myContainer.getSize()!=5){
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2结束");
        },"t2").start();
        new Thread(() ->{
           System.out.println("t1启动");
           for(int i=0;i<10;i++){
                myContainer.add(new Object());
               System.out.println("add:"+i);
               if(myContainer.getSize()==5){
                    countDownLatch.countDown();
               }
           }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t1").start();
    }


}
