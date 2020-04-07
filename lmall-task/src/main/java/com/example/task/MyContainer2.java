package com.example.task;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author long
 * @date 2020/4/1
 */
public class MyContainer2<T> {


    private final LinkedList<T> linkedList=new LinkedList<>();

    private final Integer MAX=10;

    private int count=0;


    private Lock lock=new ReentrantLock();

    private Condition producer=lock.newCondition();

    private Condition consumer=lock.newCondition();


    public void put(T t){
        try{
            lock.lock();
            while (linkedList.size()== MAX){
                producer.await();
            }
            linkedList.add(t);
            ++count;
            consumer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t=null;
        try {
            lock.lock();
            while (linkedList.size()==0){
                consumer.await();
            }
            t=linkedList.removeFirst();
            count--;
            producer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }












}
