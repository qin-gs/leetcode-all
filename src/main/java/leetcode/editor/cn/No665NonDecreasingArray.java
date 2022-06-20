////给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
////
//// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
////
////
////
//// 示例 1:
////
////
////输入: nums = [4,2,3]
////输出: true
////解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
////
////
//// 示例 2:
////
////
////输入: nums = [4,2,1]
////输出: false
////解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
////
////
////
////
//// 提示：
////
////
////
//// n == nums.length
//// 1 <= n <= 10⁴
//// -10⁵ <= nums[i] <= 10⁵
////
//// Related Topics 数组 👍 673 👎 0
//


package leetcode.editor.cn;

public class No665NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new No665NonDecreasingArray().new Solution();
        boolean b = solution.checkPossibility(new int[]{-1, 4, 2, 3});
        System.out.println("b = " + b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPossibility(int[] nums) {

            if (nums.length < 3) {
                return true;
            }
            // -1 4 2 3
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    if (i >= 2) {
                        if (nums[i] >= nums[i - 2]) {
                            nums[i - 1] = nums[i];
                        } else {
                            nums[i] = nums[i - 1];
                        }
                        count++;
                        if (count > 1) {
                            return false;
                        }
                    } else {
                        // 只针对第二个元素  [2, 1, 3, 4, 5] (不管是 2 -> 1 还是 1 -> 2/3，这里需要变一次)
                        count++;
                    }
                }
            }
            return count <= 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
