package com.example.task;

import java.util.concurrent.TimeUnit;

/**
 * @author long
 * @date 2020/4/1
 */
public class ThreadLocal1 {

    private static ThreadLocal<Person> tl=new ThreadLocal<>();


    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(tl.get());

        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();

    }










    static class Person{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
