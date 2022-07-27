// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
// 格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
// 它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//
//
// 示例 1：
//
// 输入：m = 2, n = 3, k = 1
// 输出：3
//
//
// 示例 2：
//
// 输入：m = 3, n = 1, k = 0
// 输出：1
//
//
// 提示：
//
//
// 1 <= n,m <= 100
// 0 <= k <= 20
//
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 543 👎 0


package leetcode.editor.cn;

public class NoJiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new NoJiQiRenDeYunDongFanWeiLcof().new Solution();
        int i = solution.movingCount(1, 2, 1);
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] isVisited = new boolean[m][n];
            return dfs(0, 0, m, n, k, isVisited);
        }

        private int dfs(int i, int j, int m, int n, int k, boolean[][] isVisited) {
            if (i < 0 || j < 0 || i >= m || j >= n || isVisited[i][j] || getSum(i) + getSum(j) > k) {
                return 0;
            }
            isVisited[i][j] = true;
            // 最后需要再 + 1，带上自己
            return dfs(i + 1, j, m, n, k, isVisited)
                    + dfs(i - 1, j, m, n, k, isVisited)
                    + dfs(i, j + 1, m, n, k, isVisited)
                    + dfs(i, j - 1, m, n, k, isVisited) + 1;
        }

        private int getSum(int num) {
            int ans = 0;
            while (num > 0) {
                ans += num % 10;
                num /= 10;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
