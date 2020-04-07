package com.example.task;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author long
 * @date 2020/4/1
 */
public class Ticket3 {

    private static Queue<String> queue=new ConcurrentLinkedDeque<>();

    static {
        for(int i=0;i<1000;i++){
            queue.add("票编号"+i);
        }
    }


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (true){
                    String s=queue.poll();
                    if(s==null){
                        break;
                    }
                    System.out.println("销售了---"+s);
                }
            }).start();

        }
    }





}
