package leetcode.editor.cn.printabc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {
        lockSupport(10);
    }

    private static Thread t1, t2, t3;

    public static void lockSupport(int times) {

        t1 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                System.out.println("a");
                // unpark 唤醒指定线程
                LockSupport.unpark(t2);
                // park 阻塞当前线程
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                LockSupport.park();
                System.out.println("b");
                LockSupport.unpark(t3);
            }
        });

        t3 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                LockSupport.park();
                System.out.println("c");
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
