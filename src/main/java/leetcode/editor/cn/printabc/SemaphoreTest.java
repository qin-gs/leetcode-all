package leetcode.editor.cn.printabc;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        semaphore(10);
    }


    private static void semaphore(int times) {
        // 第一个需要直接给一个信号量
        Semaphore s1 = new Semaphore(1);
        // 其它两个初始信号量为 0
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);

        new Thread(() -> {
            try {
                for (int i = 0; i < times; i++) {
                    // 获取信号量 (这个初始化为 1)
                    s1.acquire();
                    System.out.println("a");
                    // 释放下一个线程的信号量 (0 -> 1)
                    s2.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < times; i++) {
                    s2.acquire();
                    System.out.println("b");
                    s3.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < times; i++) {
                    s3.acquire();
                    System.out.println("c");
                    s1.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
