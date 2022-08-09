// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
// 回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
// 示例 1：
//
//
// 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出：[[1,6],[8,10],[15,18]]
// 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
// 输入：intervals = [[1,4],[4,5]]
// 输出：[[1,5]]
// 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti <= endi <= 10⁴
//
// Related Topics 数组 排序 👍 1596 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class No56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new No56MergeIntervals().new Solution();
        int[][] merge = solution.merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}});
        System.out.println(Arrays.deepToString(merge));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] ints) {
            // 将数组按照第 0 个值排序
            int[][] intervals = Arrays.stream(ints)
                    .sorted(Comparator.comparingInt(o -> o[0]))
                    .toArray(int[][]::new);
            Deque<Integer[]> deque = new LinkedList<>();
            int last = -1;
            for (int[] interval : intervals) {
                // 如果 下一个的第 0 个元素 > 上一个的第 1 个元素。说明不重叠
                if (interval[0] > last) {
                    deque.add(new Integer[]{interval[0], interval[1]});
                    last = interval[1];
                } else {
                    // 如果重叠了，取出队列中的最后一个元素 和 当前元素比较，判断是否更新
                    Integer[] peek = deque.peekLast();
                    peek[1] = Math.max(interval[1], peek[1]);
                    last = Math.max(last, peek[1]);
                }
            }
            int size = deque.size();
            int[][] ans = new int[size][2];
            for (int i = 0; i < size; i++) {
                Integer[] pop = deque.pollFirst();
                ans[i] = new int[]{pop[0], pop[1]};
            }
            // 直接 toArray 不对
            // return deque.toArray(new int[0][0]);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
