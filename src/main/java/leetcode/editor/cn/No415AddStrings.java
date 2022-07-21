// 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
//
//
//
// 示例 1：
//
//
// 输入：num1 = "11", num2 = "123"
// 输出："134"
//
//
// 示例 2：
//
//
// 输入：num1 = "456", num2 = "77"
// 输出："533"
//
//
// 示例 3：
//
//
// 输入：num1 = "0", num2 = "0"
// 输出："0"
//
//
//
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 10⁴
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
//
// Related Topics 数学 字符串 模拟 👍 589 👎 0


package leetcode.editor.cn;

public class No415AddStrings {
    public static void main(String[] args) {
        Solution solution = new No415AddStrings().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder ans = new StringBuilder(num1.length());
            // 当前位，进位
            int curr = 0;
            int carry = 0;
            int first = num1.length() - 1, second = num2.length() - 1;
            while (first >= 0 || second >= 0) {
                int i = 0;
                if (first >= 0) {
                    i = num1.charAt(first) - '0';
                }
                int j = 0;
                if (second >= 0) {
                    j = num2.charAt(second) - '0';
                }
                curr = (i + j + carry) % 10;
                carry = (i + j + carry) / 10;
                ans.append(curr);
                first--;
                second--;
            }
            if (carry > 0) {
                ans.append(1);
            }
            return ans.reverse().toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
