// 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。
//
// 示例:
//
// 输入: "Hello, my name is John"
// 输出: 5
// 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
//
// Related Topics 字符串 👍 174 👎 0


package leetcode.editor.cn;

public class No434NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new No434NumberOfSegmentsInAString().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            if (s.length() == 0) {
                return 0;
            }

            // "Hello, my name is John"
            // 出现一个空格，并且前面一个不是空格，说明是一个单词
            int count = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                    count++;
                }
            }
            // "apple" 需要额外判断最后一个单词
            if (s.charAt(s.length() - 1) != ' ') {
                count++;
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
