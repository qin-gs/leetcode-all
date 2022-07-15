// 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例 1：
//
//
// 输入：s = "Let's take LeetCode contest"
// 输出："s'teL ekat edoCteeL tsetnoc"
//
//
// 示例 2:
//
//
// 输入： s = "God Ding"
// 输出："doG gniD"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 5 * 10⁴
// s 包含可打印的 ASCII 字符。
// s 不包含任何开头或结尾空格。
// s 里 至少 有一个词。
// s 中的所有单词都用一个空格隔开。
//
// Related Topics 双指针 字符串 👍 459 👎 0


package leetcode.editor.cn;

public class No557ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new No557ReverseWordsInAStringIii().new Solution();
        String s = solution.reverseWords("I love u");
        System.out.println("s = " + s);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int left = 0, right = 0;
            char[] array = s.toCharArray();
            while (left < s.length()) {
                // 寻找 left
                // 用 while 更好
                for (int i = left; i < s.length(); i++) {
                    if (array[i] != ' ') {
                        left = i;
                        break;
                    }
                }
                // 寻找right
                // 这里 i 不能直接赋值成 left+1，如果最后一个单词只有一个字母会有问题 (i love u)
                for (int i = left; i < s.length(); i++) {
                    if (array[i] == ' ') {
                        right = i - 1;
                        break;
                    }
                    // 到末尾需要额外判断
                    if (i == s.length() - 1) {
                        right = s.length() - 1;
                        break;
                    }
                }
                // 交换一个单词
                int r = right;
                while (left < right) {
                    char tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                    left++;
                    right--;
                }
                // 交换完之后
                left = r + 2;
            }
            return new String(array);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
