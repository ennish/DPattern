package com.enn.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleDog {
    private static int count = 0;
    //	private static final  SingleDog singleDog = new SingleDog();//饱汉
    private static SingleDog singleDog = null;

    // 私有化构造函数,singleton的普遍做法
    private SingleDog() {
        count++;
        System.out.println("Congratulation,you create no" + count + " single dog!");
    }

    public static SingleDog newInstance() throws InterruptedException {
        if (singleDog == null) {
            //加上这段，多线程执行时其他线程插入的可能性大大增加
            //Thread.sleep(10L);
            singleDog = new SingleDog();
        }
        return singleDog;
    }

    public static void main(String[] args) {
        /**
         * 该种方式不支持多线程，原因是在 if(singleDog==null){
         * 与 singleDog = new SingleDog();之间如果有其他线程
         * 进来的话，可能会初始化多个SingleDog
         */
        int ths = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(ths);
        try {
            for (int i = 0; i < ths; i++) {
                executorService.submit(() -> {
                    try {
                        SingleDog dog = SingleDog.newInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(SingleDog.count);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
