package com.atguigu.mybatis.utils;

/**
 * @author yang
 * @date 2024/04/10
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
         /*System.out.println("睡觉前");
         Thread.sleep(3000);
         System.out.println("睡醒了");*/

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t2.setName("飞机");

        t1.start();
        t2.start();
    }
}
