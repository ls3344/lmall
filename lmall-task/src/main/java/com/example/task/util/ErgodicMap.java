package com.example.task.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author long
 * @date 2020/4/1
 */
public class ErgodicMap {

    private static final Map<Integer,String> stringMap=new HashMap<>();


    public void ergodicMap1(){
        stringMap.put(1,"测试1");
        stringMap.put(2,"测试2");
        stringMap.put(3,"测试3");
        stringMap.put(4,"测试4");
        stringMap.put(5,"测试5");
        stringMap.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }

    public void ergodicMap2(){
        stringMap.put(1,"测试1");
        stringMap.put(2,"测试2");
        stringMap.put(3,"测试3");
        stringMap.put(4,"测试4");
        stringMap.put(5,"测试5");

        stringMap.entrySet().stream().forEach((integerStringEntry -> {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
        }));
    }







    public static void main(String[] args) {
        ErgodicMap ergodicMap=new ErgodicMap();
        ergodicMap.ergodicMap1();
        ergodicMap.ergodicMap2();
    }




}
