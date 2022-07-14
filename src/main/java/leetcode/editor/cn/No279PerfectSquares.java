// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
// 输入：n = 12
// 输出：3
// 解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
// 输入：n = 13
// 输出：2
// 解释：13 = 4 + 9
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1425 👎 0


package leetcode.editor.cn;

public class No279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new No279PerfectSquares().new Solution();
        int i = solution.numSquares(12);
        System.out.println("i = " + i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            // 1 2 3 4 5 6 7 8
            // 1 2 3 1 2 3 4 2
            int[] ans = new int[n + 1];
            ans[0] = 0;
            ans[1] = 1;
            for (int i = 2; i <= n; i++) {
                // 最多需要 n 个 1
                ans[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
                }
            }
            return ans[n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
