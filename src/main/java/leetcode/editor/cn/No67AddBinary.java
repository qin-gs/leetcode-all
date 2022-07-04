// 给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
// 输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
// 输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 位运算 数学 字符串 模拟 👍 839 👎 0


package leetcode.editor.cn;

public class No67AddBinary {

    public static void main(String[] args) {
        Solution solution = new No67AddBinary().new Solution();
        String s = solution.addBinary("11", "1");
        System.out.println(s);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int lenA = a.length() - 1;
            int lenB = b.length() - 1;
            StringBuilder ans = new StringBuilder();
            // 记录进位
            int carry = 0;
            while (lenA >= 0 || lenB >= 0) {
                int first = 0, second = 0, sum;
                if (lenA >= 0) {
                    first = a.charAt(lenA--) - '0';
                }
                if (lenB >= 0) {
                    second = b.charAt(lenB--) - '0';
                }
                // 当前位
                sum = (first + second + carry) % 2;
                // 是否需要进位
                carry = (first + second + carry) / 2;
                ans.append(sum);
            }
            // 是否还需要进位
            if (carry == 1) {
                ans.append(carry);
            }
            return ans.reverse().toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
