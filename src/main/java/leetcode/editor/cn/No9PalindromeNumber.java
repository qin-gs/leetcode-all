// 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//
// 例如，121 是回文，而 123 不是。
//
//
//
//
// 示例 1：
//
//
// 输入：x = 121
// 输出：true
//
//
// 示例 2：
//
//
// 输入：x = -121
// 输出：false
// 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
// 输入：x = 10
// 输出：false
// 解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学 👍 2063 👎 0


package leetcode.editor.cn;

public class No9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new No9PalindromeNumber().new Solution();
        solution.reverse(12321);
        // boolean palindrome = solution.isPalindrome(2);
        // System.out.println(palindrome);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            // 先判断数字有多少位
            int bit = 1;
            int tmp = x;
            while (tmp >= 10) {
                bit *= 10;
                tmp /= 10;
            }
            // 比较第一位 和 最后一位
            while (x > 0) {
                int low = x % 10;
                int high = x / bit;
                if (high != low) {
                    return false;
                }
                // 去掉原数字的第一位 和 最后一位
                x %= bit;
                x /= 10;

                bit /= 100;
            }
            return true;
        }


        public boolean reverse(int x) {
            // 反转数字的后一半
            if (x < 0) {
                return false;
            }
            // 最后一位不能是 0
            if (x % 10 == 0 && x != 0) {
                return false;
            }

            int reverse = 0;
            // 判断是否反转到一半
            while (x > reverse) {
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
            // 数字位数是奇数的话，需要 / 10 判断
            // 12321  x = 12, reverse = 123
            // 1221   x = 12, reverse = 12
            return x == reverse || x == reverse / 10;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
