package com.example.model;

/**
 * @author long
 * @date 2020/4/1
 */
public class Singleton {

    private void SingleTon(){
        System.out.println("single");
    }

    private static class Inner{
        private Singleton s=new Singleton();
    }

    public static Singleton getSingleTon(){
        return new Inner().s;
    }






}
