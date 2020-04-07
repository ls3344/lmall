package com.example.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author long
 * @date 2020/4/1
 */
public class TConcurrentMap {


    public static void main(String[] args) {
        Map<Integer,String> map=new ConcurrentHashMap<>();
        Map<Integer,String> hMap=new ConcurrentSkipListMap<>();
    }


}
