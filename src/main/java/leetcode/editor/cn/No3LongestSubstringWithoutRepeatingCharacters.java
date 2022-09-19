// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8170 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class No3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new No3LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 记录字符最后一次出现的索引位置
            Map<Character, Integer> map = new HashMap<>();
            int res = 0, tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                // 之前相同字符出现的位置
                int j = map.getOrDefault(s.charAt(i), -1);
                // 把当前字符放进去，更新
                map.put(s.charAt(i), i);
                // 两个相同字符之间的距离
                int distance = i - j;
                // 如果上一次出现的位置不在当前最长不重复的子串中，直接增加长度
                if (tmp < distance) {
                    tmp = tmp + 1;
                } else {
                    tmp = distance;
                }
                res = Math.max(res, tmp);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static String find(String str) {
        Map<Character, Integer> map = new HashMap<>();
        // 最大长度
        int maxLen = 0;
        // 当前长度
        int len = 0;
        // 子串开始下标
        int startIndex = 0;
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            if (map.containsKey(str.charAt(end))) {
                // 如果存在说明字符重复，移动 start，找到了一个
                start = map.get(str.charAt(end)) + 1;
                // 初始化其他值
                len = 0;
                map.clear();
                // 从重复的(start)下一个字符开始
                end = start;
            } else {
                // 不存在的话，增加当前长度
                len++;
                map.put(str.charAt(end), end);
                // 如果比最长的还长，更新最长的字符串
                if (len > maxLen) {
                    maxLen = len;
                    startIndex = start;
                }
            }
        }
        // 截取
        return str.substring(startIndex, startIndex + maxLen);
    }

}
