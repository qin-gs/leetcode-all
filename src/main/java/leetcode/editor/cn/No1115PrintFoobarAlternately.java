//给你一个类：
//
//
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
//
//
// 两个不同的线程将会共用一个 FooBar 实例：
//
//
// 线程 A 将会调用 foo() 方法，而
// 线程 B 将会调用 bar() 方法
//
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出："foobar"
//解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
//
//
// 示例 2：
//
//
//输入：n = 2
//输出："foobarfoobar"
//解释："foobar" 将被输出两次。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1000
//
// Related Topics 多线程 👍 162 👎 0


package leetcode.editor.cn;

import java.util.concurrent.Semaphore;

public class No1115PrintFoobarAlternately {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        private Semaphore s1 = new Semaphore(1);
        private Semaphore s2 = new Semaphore(0);

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                s1.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                s2.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                s2.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                s1.release();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
