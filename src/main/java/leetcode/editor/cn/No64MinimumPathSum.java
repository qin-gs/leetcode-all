// 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
// 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
// 输出：7
// 解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
// 输入：grid = [[1,2,3],[4,5,6]]
// 输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划 矩阵 👍 1314 👎 0


package leetcode.editor.cn;

public class No64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new No64MinimumPathSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] ans = new int[grid.length][grid[0].length];
            ans[0][0] = grid[0][0];
            for (int i = 1; i < grid.length; i++) {
                ans[i][0] = grid[i][0] + ans[i - 1][0];
            }
            for (int i = 1; i < grid[0].length; i++) {
                ans[0][i] = grid[0][i] + ans[0][i - 1];
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[1].length; j++) {
                    ans[i][j] = Math.min(ans[i - 1][j], ans[i][j - 1]) + grid[i][j];
                }
            }
            return ans[grid.length - 1][grid[0].length - 1];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
