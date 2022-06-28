// 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
//
// 示例 2：
//
//
// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
//
// 示例 3：
//
//
// 输入：nums = [], target = 0
// 输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 👍 1763 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class No34FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new No34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ans = solution.searchRange(nums, 8);
        System.out.println(Arrays.toString(ans));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};
            ans[0] = search(nums, target, true);
            ans[1] = search(nums, target, false);
            return ans;
        }

        /**
         * 寻找左边界，从右向左逼近 (因为可能不存在)
         */
        public int search(int[] nums, int target, boolean isLeft) {
            int low = 0, high = nums.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    ans = mid;
                    // 如果寻找左边界，可能左边还有相同的值
                    if (isLeft) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
