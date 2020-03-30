package com.example.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author long
 * @date 2020/3/25
 */
public class MyContainer1 {

    private final List<Integer> list = new ArrayList<>();
    public int getSize() {
        return list.size();
    }
    public void add(int i) {
        list.add(i);
    }
    public static void main(String[] args) throws Exception {
        MyContainer1 mqTest = new MyContainer1();
        new Thread(() -> {
            try {
                for (int i = 1; i < 10; i++) {
                    mqTest.add(i);
                    System.out.println("i="+i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    if (mqTest.getSize() == 5) {
                        System.out.println("我停止了");
                        break;
                    }
                    else {
                        System.out.println("");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("========");
        TimeUnit.SECONDS.sleep(20);
        System.out.println("最后我停止了");
    }

}
