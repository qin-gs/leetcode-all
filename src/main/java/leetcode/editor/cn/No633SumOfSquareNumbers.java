// 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。
//
//
//
// 示例 1：
//
//
// 输入：c = 5
// 输出：true
// 解释：1 * 1 + 2 * 2 = 5
//
//
// 示例 2：
//
//
// 输入：c = 3
// 输出：false
//
//
//
//
// 提示：
//
//
// 0 <= c <= 2³¹ - 1
//
// Related Topics 数学 双指针 二分查找 👍 368 👎 0


package leetcode.editor.cn;

public class No633SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new No633SumOfSquareNumbers().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            int low = 0;
            double high = Math.floor(Math.sqrt(c));
            while (low <= high) {
                double sum = low * low + high * high;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    high --;
                } else {
                    low++;
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
