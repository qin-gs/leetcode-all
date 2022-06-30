// 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
// 输入：nums = [3,2,3]
// 输出：3
//
// 示例 2：
//
//
// 输入：nums = [2,2,1,1,1,2,2]
// 输出：2
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
// Related Topics 数组 哈希表 分治 计数 排序 👍 1476 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class No169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new No169MajorityElement().new Solution();
        int i = solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 分治：如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数。
         */
        public int majorityElement(int[] nums) {
            return majorityElement(nums, 0, nums.length - 1);
        }

        private int majorityElement(int[] nums, int start, int end) {
            // 如果只有一个数，它就是众数
            if (start == end) {
                return nums[start];
            }
            int mid = (start + end) / 2;
            // 分别计算左边 和 右边的众数
            int left = majorityElement(nums, start, mid);
            int right = majorityElement(nums, mid + 1, end);
            // 如果两边的一样就找到了
            if (left == right) {
                return left;
            }

            // 如果两边不一样，需要统计在整个数字中的数量，大的是众数
            // [3, 2, 3] 这个数组拆分
            // [3, 2] 返回的众数是 2
            // [3]    返回的众数是 3
            // 需要统计出现次数
            int leftCount = countInArray(nums, left, start, end);
            int rightCount = countInArray(nums, right, start, end);
            return leftCount > rightCount ? left : right;
        }

        private int countInArray(int[] nums, int num, int left, int right) {
            return (int) IntStream.rangeClosed(left, right).filter(i -> nums[i] == num).count();
        }

        public int majorityElement2(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            Map.Entry<Integer, Integer> max = null;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (max == null || max.getValue() < entry.getValue()) {
                    max = entry;
                }
            }
            return max.getValue();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
