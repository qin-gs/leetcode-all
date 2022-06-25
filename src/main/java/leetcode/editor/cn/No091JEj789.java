// 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵
// costs 来表示的。
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
//
// 请计算出粉刷完所有房子最少的花费成本。
//
//
//
// 示例 1：
//
//
// 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
// 输出: 10
// 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
//
//
// 示例 2：
//
//
// 输入: costs = [[7,6,2]]
// 输出: 2
//
//
//
//
// 提示:
//
//
// costs.length == n
// costs[i].length == 3
// 1 <= n <= 100
// 1 <= costs[i][j] <= 20
//
//
//
//
// 注意：本题与主站 256 题相同：https://leetcode-cn.com/problems/paint-house/
// Related Topics 数组 动态规划 👍 58 👎 0


package leetcode.editor.cn;

public class No091JEj789 {
    public static void main(String[] args) {
        Solution solution = new No091JEj789().new Solution();
        int[][] nums = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int i = solution.minCost(nums);
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 用一维数组只保留上一个中间值
         */
        public int minCost_(int[][] costs) {
            if (costs.length == 1) {
                return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
            }
            int[] ans = {costs[0][0], costs[0][1], costs[0][2]};
            for (int i = 1; i < costs.length; i++) {
                int[] tmp = new int[3];
                tmp[0] = Math.min(ans[1], ans[2]) + costs[i][0];
                tmp[1] = Math.min(ans[0], ans[2]) + costs[i][1];
                tmp[2] = Math.min(ans[0], ans[1]) + costs[i][2];
                ans = tmp;
            }
            return Math.min(Math.min(ans[0], ans[1]), ans[2]);
        }

        /**
         * 用二位数组保存所有中间值
         */
        public int minCost(int[][] costs) {
            if (costs.length == 1) {
                return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
            }
            int[][] ans = new int[3][costs.length];
            ans[0][0] = costs[0][0];
            ans[1][0] = costs[0][1];
            ans[2][0] = costs[0][2];
            for (int i = 1; i < costs.length; i++) {
                ans[0][i] = Math.min(ans[1][i - 1], ans[2][i - 1]) + costs[i][0];
                ans[1][i] = Math.min(ans[0][i - 1], ans[2][i - 1]) + costs[i][1];
                ans[2][i] = Math.min(ans[0][i - 1], ans[1][i - 1]) + costs[i][2];
            }

            return Math.min(Math.min(ans[0][costs.length - 1], ans[1][costs.length - 1]), ans[2][costs.length - 1]);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
