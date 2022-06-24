//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 2081 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class No46Permutations {
    public static void main(String[] args) {
        Solution solution = new No46Permutations().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
            backtrack(l, result, nums.length, 0);
            return result;
        }

        private void backtrack(List<Integer> l, List<List<Integer>> result, int length, int curr) {
            if (length == curr) {
                result.add(new ArrayList<>(l));
                return;
            }
            for (int i = curr; i < length; i++) {
                Collections.swap(l, curr, i);
                backtrack(l, result, length, curr + 1);
                Collections.swap(l, curr, i);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
