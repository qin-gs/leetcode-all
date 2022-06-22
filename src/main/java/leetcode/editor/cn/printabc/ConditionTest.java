package leetcode.editor.cn.printabc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印 abc n 次
 */
public class ConditionTest {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition c1 = lock.newCondition();
    private static final Condition c2 = lock.newCondition();
    private static final Condition c3 = lock.newCondition();
    private static volatile int num = 1;

    public static void main(String[] args) {
        int times = 100;

        new Thread(() -> {

            for (int i = 0; i < times; i++) {
                // 获取到锁
                lock.lock();
                try {
                    // 没有轮到自己，等待
                    if (num != 1) {
                        c1.await();
                    }
                    System.out.println("a");
                    // 修改数字，唤醒下一个
                    num = 2;
                    c2.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {

                lock.lock();
                try {
                    if (num != 2) {
                        c2.await();
                    }
                    System.out.println("b");
                    num = 3;
                    c3.signal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {

                lock.lock();
                try {
                    if (num != 3) {
                        c3.await();
                    }
                    System.out.println("c");
                    num = 1;
                    c1.signal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();


    }

}
