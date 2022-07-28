// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组 矩阵 模拟 👍 436 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class NoShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new NoShunShiZhenDaYinJuZhenLcof().new Solution();
        int[] ans = solution.spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}});
        System.out.println(Arrays.toString(ans));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            // 1  2  3  4  5
            // 12 13 14 15 6
            // 11 10 9  8  7

            if (matrix.length == 0) {
                return new int[0];
            }
            int[] res = new int[matrix.length * matrix[0].length];
            int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
            int idx = 0;
            while (true) {
                // 上面：从左到右
                for (int i = l; i <= r; i++) {
                    res[idx++] = matrix[u][i];
                }
                if (++u > d) {
                    break;
                }
                // 右侧：从上到下
                for (int i = u; i <= d; i++) {
                    res[idx++] = matrix[i][r];
                }
                if (--r < l) {
                    break;
                }
                // 下面：从右到左
                for (int i = r; i >= l; i--) {
                    res[idx++] = matrix[d][i];
                }
                if (--d < u) {
                    break;
                }
                // 左侧：从下到上
                for (int i = d; i >= u; i--) {
                    res[idx++] = matrix[i][l];
                }
                if (++l > r) {
                    break;
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
