// 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
//
//
//
// 示例 1:
//
//
// 输入:s = "abccccdd"
// 输出:7
// 解释:
// 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//
//
// 示例 2:
//
//
// 输入:s = "a"
// 输入:1
//
//
// 示例 3:
//
//
// 输入:s = "bb"
// 输入: 2
//
//
//
//
// 提示:
//
//
// 1 <= s.length <= 2000
// s 只能由小写和/或大写英文字母组成
//
// Related Topics 贪心 哈希表 字符串 👍 435 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class No409LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new No409LongestPalindrome().new Solution();
        int ans = solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        System.out.println("ans = " + ans);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
            }
            int ans = 0;
            // 记录有没有数量是奇数的字符
            int add = 0;
            for (Map.Entry<Character, Integer> entry : count.entrySet()) {
                Integer value = entry.getValue();
                // 偶数个全部都能放上去
                if (value % 2 == 0) {
                    ans += value;
                } else {
                    // 奇数个只能加上一个作为中心
                    ans += value - 1;
                    add = 1;
                }
            }
            return ans + add;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
