// 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
//
//
//
// 示例 1：
//
//
// 输入：n = 1
// 输出：true
// 解释：2⁰ = 1
//
//
// 示例 2：
//
//
// 输入：n = 16
// 输出：true
// 解释：2⁴ = 16
//
//
// 示例 3：
//
//
// 输入：n = 3
// 输出：false
//
//
// 示例 4：
//
//
// 输入：n = 4
// 输出：true
//
//
// 示例 5：
//
//
// 输入：n = 5
// 输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= n <= 2³¹ - 1
//
//
//
//
// 进阶：你能够不使用循环/递归解决此问题吗？
// Related Topics 位运算 递归 数学 👍 524 👎 0


package leetcode.editor.cn;

public class No231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new No231PowerOfTwo().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            // 对于 2 ^ n
            // 8 和 -8 的二进制表示 (8 % -8 = 8)
            // 8  00000000000000000000000000001000  原码
            // -8 11111111111111111111111111111000  补码
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
