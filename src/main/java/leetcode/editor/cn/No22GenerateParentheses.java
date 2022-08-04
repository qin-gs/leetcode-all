// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
// 输入：n = 3
// 输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
// 输入：n = 1
// 输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 动态规划 回溯 👍 2791 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new No22GenerateParentheses().new Solution();
        List<String> ans = solution.generateParenthesis(3);
        System.out.println(ans);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, n, "");
            return res;
        }

        private void dfs(int left, int right, String curStr) {
            // 左右括号都不剩余了，递归终止
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }

            // 如果左括号还剩余的话，可以拼接左括号
            if (left > 0) {
                dfs(left - 1, right, curStr + "(");
            }
            // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            if (right > left) {
                dfs(left, right - 1, curStr + ")");
            }
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
