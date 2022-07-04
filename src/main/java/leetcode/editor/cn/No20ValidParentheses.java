// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
// 输入：s = "()"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：s = "()[]{}"
// 输出：true
//
//
// 示例 3：
//
//
// 输入：s = "(]"
// 输出：false
//
//
// 示例 4：
//
//
// 输入：s = "([)]"
// 输出：false
//
//
// 示例 5：
//
//
// 输入：s = "{[]}"
// 输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串 👍 3362 👎 0


package leetcode.editor.cn;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class No20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new No20ValidParentheses().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            // 使用 map 存储
            Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
            for (char c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    // c = (, [, {
                    stack.push(c);
                } else {
                    // c = ) ] }
                    if (stack.empty()) {
                        return false;
                    }
                    if (!Objects.equals(stack.pop(), map.get(c))) {
                        return false;
                    }
                }
            }
            return stack.empty();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
