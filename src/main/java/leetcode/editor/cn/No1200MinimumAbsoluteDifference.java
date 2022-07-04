// 给你个整数数组 arr，其中每个元素都 不相同。
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
//
//
//
// 示例 1：
//
// 输入：arr = [4,2,1,3]
// 输出：[[1,2],[2,3],[3,4]]
//
//
// 示例 2：
//
// 输入：arr = [1,3,6,10,15]
// 输出：[[1,3]]
//
//
// 示例 3：
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
// 输出：[[-14,-10],[19,23],[23,27]]
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 10^5
// -10^6 <= arr[i] <= 10^6
//
// Related Topics 数组 排序 👍 97 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1200MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Solution solution = new No1200MinimumAbsoluteDifference().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            // 先排序
            Arrays.sort(arr);
            int min = arr[1] - arr[0];
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) {
                // 计算相邻两个数的差值
                int tmp = arr[i] - arr[i - 1];
                // 如果比之前的最小值还要小，清空之前存储的结果，更新最小值
                if (tmp < min) {
                    min = tmp;
                    ans.clear();
                    ans.add(Arrays.asList(arr[i - 1], arr[i]));
                } else if (tmp == min) {
                    // 如果相邻两个数的差和最小值相等，加到结果集中
                    ans.add(Arrays.asList(arr[i - 1], arr[i]));
                }
                // 如果相邻两个数的差比之前大，不处理
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
