// 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
// 示例 1：
//
//
// 输入：nums1 = [1,3], nums2 = [2]
// 输出：2.00000
// 解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
// 输入：nums1 = [1,2], nums2 = [3,4]
// 输出：2.50000
// 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10⁶ <= nums1[i], nums2[i] <= 10⁶
//
// Related Topics 数组 二分查找 分治 👍 5712 👎 0


package leetcode.editor.cn;

public class No4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new No4MedianOfTwoSortedArrays().new Solution();
        double d = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3});
        System.out.println(d);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int sum = nums1.length + nums2.length;
            // 如果是奇数个，就是 index
            // 如果是偶数个，(index-1 + index) / 2
            int index = sum / 2;
            // 分别记录第 index-1 和 index 的值
            int cur = 0, pre = 0;
            int first = 0, second = 0;
            // 避免数组越界
            while (first < nums1.length && second < nums2.length && first + second <= index) {
                pre = cur;
                if (nums1[first] <= nums2[second]) {
                    cur = nums1[first++];
                } else {
                    cur = nums2[second++];
                }
            }
            // 如果一个数组遍历完了还没到中位数，还要去另一个数组里继续找
            if (first < nums1.length) {
                while (first + second <= index) {
                    pre = cur;
                    cur = nums1[first++];
                }
            }
            if (second < nums2.length) {
                while (first + second <= index) {
                    pre = cur;
                    cur = nums2[second++];
                }
            }
            return sum % 2 == 0 ? (pre + cur) / 2d : cur;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
