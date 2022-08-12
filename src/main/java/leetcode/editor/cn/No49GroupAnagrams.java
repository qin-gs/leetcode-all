// 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
//
//
//
// 示例 1:
//
//
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
// 输入: strs = [""]
// 输出: [[""]]
//
//
// 示例 3:
//
//
// 输入: strs = ["a"]
// 输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
// Related Topics 数组 哈希表 字符串 排序 👍 1221 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new No49GroupAnagrams().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                // 统计字符串中每个字符出现的次数
                int[] counts = new int[26];
                for (byte b : str.getBytes()) {
                    counts[b - 'a'] = counts[b - 'a'] + 1;
                }
                // 记录当前字符串
                StringBuilder key = new StringBuilder();
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] > 0) {
                        key.append(counts[i]).append('a' + i);
                    }
                }
                List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
                list.add(str);
                map.put(key.toString(), list);
            }
            return new ArrayList<>(map.values());
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
