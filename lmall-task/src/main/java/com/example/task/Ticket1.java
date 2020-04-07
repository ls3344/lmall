package com.example.task;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @author long
 * @date 2020/4/1
 */
public class Ticket1 {

    private static Vector<String> vector=new Vector<>();

    static {
        for (int i=0;i<1000;i++){
            vector.add("票编号"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (vector.size()>0){
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("销售了-----"+vector.remove(0));
                }
            }).start();
        }
    }




}
