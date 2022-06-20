//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
//
//
//
// 示例 1：
//
//
//输入：s = "hello"
//输出："holle"
//
//
// 示例 2：
//
//
//输入：s = "leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由 可打印的 ASCII 字符组成
//
// Related Topics 双指针 字符串 👍 251 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Locale;

public class No345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new No345ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            int i = 0, j = s.length() - 1;
            char[] res = new char[s.length()];
            while (i < j) {
                while (i < s.length()) {
                    if (isVowel(s.charAt(i))) {
                        break;
                    }
                    res[i] = s.charAt(i);
                    i++;
                }
                while (j >= 0) {
                    if (isVowel(s.charAt(j))) {
                        break;
                    }
                    res[j] = s.charAt(j);
                    j--;
                }
                if (i < j) {
                    res[i++] = s.charAt(j);
                    res[j--] = s.charAt(i);
                } else {
                    break;
                }
            }
            return new String(res);
        }

        private boolean isVowel(char c) {
            return Arrays.asList("a", "e", "i", "o", "u").contains(String.valueOf(c).toLowerCase(Locale.ROOT));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
