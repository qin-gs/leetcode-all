// 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
//
//
// Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
// Paste（粘贴）：粘贴 上一次 复制的字符。
//
//
// 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
//
//
//
// 示例 1：
//
//
// 输入：3
// 输出：3
// 解释：
// 最初, 只有一个字符 'A'。
// 第 1 步, 使用 Copy All 操作。
// 第 2 步, 使用 Paste 操作来获得 'AA'。
// 第 3 步, 使用 Paste 操作来获得 'AAA'。
//
//
// 示例 2：
//
//
// 输入：n = 1
// 输出：0
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1000
//
// Related Topics 数学 动态规划 👍 468 👎 0


package leetcode.editor.cn;

public class No650TwoKeysKeyboard {
    public static void main(String[] args) {
        Solution solution = new No650TwoKeysKeyboard().new Solution();
        int i = solution.minSteps(9);
        System.out.println("i = " + i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(int n) {
            if (n == 1) {
                return 0;
            }
            int maxFactor = 1;
            // 找 n 的最大公因数 ( 18 的话找到 9 )
            for (int i = n - 1; i >= 1; i--) {
                if (n % i == 0) {
                    maxFactor = i;
                    break;
                }
            }
            // n 是质数，只能一个一个复制粘贴
            if (maxFactor == 1) {
                return n;
            }
            // 9 到 18 需要复制 (18 / 9 = 2) 次，然后计算得到 9 需要几次
            return n / maxFactor + minSteps(maxFactor);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
