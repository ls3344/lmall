package com.example.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author long
 * @date 2020/4/1
 */
public class Ticket {

    private static List<String> list=new ArrayList<>();

    static {
        for (int i=0;i<1000;i++){
            list.add("票编号"+i);
        }
    }


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (list.size()>0){
                    try{
                        TimeUnit.MILLISECONDS.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println("销售了-----"+list.remove(0));
                }
            }).start();
        }
    }



}
