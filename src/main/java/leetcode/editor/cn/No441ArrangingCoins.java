// 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
//
//
//
// 示例 1：
//
//
// 输入：n = 5
// 输出：2
// 解释：因为第三行不完整，所以返回 2 。
//
//
// 示例 2：
//
//
// 输入：n = 8
// 输出：3
// 解释：因为第四行不完整，所以返回 3 。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
// Related Topics 数学 二分查找 👍 231 👎 0


package leetcode.editor.cn;

public class No441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new No441ArrangingCoins().new Solution();
        int i = solution.arrangeCoins(5);
        System.out.println("i = " + i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            int left = 1, right = n;
            while (left < right) {
                // 这里需要 +1
                // 如果 n=5，mid=1 会进入死循环
                int mid = left + (right - left) / 2 + 1;
                long num = (1L + mid) * mid / 2;
                if (num <= n) {
                    // 这里必须是 mid，不能是 mid+1，因为 mid+1 求和后可能大于 n
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
