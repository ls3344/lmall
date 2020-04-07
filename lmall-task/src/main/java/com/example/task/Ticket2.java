package com.example.task;

import java.util.LinkedList;

/**
 * @author long
 * @date 2020/4/1
 */
public class Ticket2 {

    private static LinkedList<String> linkedList=new LinkedList<>();

    static {
        for (int i=0;i<1000;i++){
            linkedList.add("票编号"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                synchronized (linkedList){
                    while (linkedList.size()>0){
                        System.out.println("销售了----"+linkedList.remove(0));
                    }
                }
            }).start();
        }
    }




}
