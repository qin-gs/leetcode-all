// 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//
//
//
// 必须在不使用库的sort函数的情况下解决这个问题。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]
//
//
// 示例 2：
//
//
// 输入：nums = [2,0,1]
// 输出：[0,1,2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2
//
//
//
//
// 进阶：
//
//
// 你可以不使用代码库中的排序函数来解决这道题吗？
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 数组 双指针 排序 👍 1367 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class No75SortColors {
    public static void main(String[] args) {
        Solution solution = new No75SortColors().new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int index = 0;
            // 先将 0 移到头部
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    swap(nums, index, i);
                    index++;
                }
            }
            // 将 1 移到 0 的后面
            for (int i = index; i < nums.length; i++) {
                if (nums[i] == 1) {
                    swap(nums, index, i);
                    index++;
                }
            }
        }

        public void sortColors2(int[] nums) {
            // 使用两个指针，把 0 向前移动，把 2 向后移动
            int head = 0, tail = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if (head >= tail) {
                    return;
                }
                // 把 0 向后移
                if (nums[i] == 0) {
                    swap(nums, i, head);
                    head++;
                } else if (nums[i] == 2) {
                    // 把 2 向后移，可能又移过来一个 2，使用 while
                    while (nums[i] == 2) {
                        swap(nums, i, tail);
                        tail--;
                    }
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
