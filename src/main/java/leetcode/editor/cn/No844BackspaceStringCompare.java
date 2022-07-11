// 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
// 示例 1：
//
//
// 输入：s = "ab#c", t = "ad#c"
// 输出：true
// 解释：s 和 t 都会变成 "ac"。
//
//
// 示例 2：
//
//
// 输入：s = "ab##", t = "c#d#"
// 输出：true
// 解释：s 和 t 都会变成 ""。
//
//
// 示例 3：
//
//
// 输入：s = "a#c", t = "b"
// 输出：false
// 解释：s 会变成 "c"，但 t 仍然是 "b"。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 200
// s 和 t 只含有小写字母以及字符 '#'
//
//
//
//
// 进阶：
//
//
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
//
// Related Topics 栈 双指针 字符串 模拟 👍 460 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class No844BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new No844BackspaceStringCompare().new Solution();
        solution.backspaceCompare("y#fo##f", "y#f#o##f");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '#') {
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                } else {
                    stack1.push(s.charAt(i));
                }
            }
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == '#') {
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                    }
                } else {
                    stack2.push(t.charAt(i));
                }
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
            while (!stack1.isEmpty()) {
                if (!stack1.pop().equals(stack2.pop())) {
                    return false;
                }
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i > 0 || j > 0) {
            while (i > 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    i--;
                } else {
                    break;
                }
            }
            while (j > 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

}
