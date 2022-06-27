// 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
//
//
//
//
// 示例 1：
//
//
// 输入：n = 3
// 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
//
//
// 示例 2：
//
//
// 输入：n = 1
// 输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
//
//
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1238 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new No95UniqueBinarySearchTreesIi().new Solution();
        List<TreeNode> trees = solution.generateTrees(5);
        System.out.println(trees);
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * <pre>
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     * </pre>
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> ans = new ArrayList<>();
            if (start > end) {
                ans.add(null);
                return ans;
            }
            // 依次作为根节点
            for (int i = start; i <= end; i++) {
                // 获取所有的左子树
                List<TreeNode> leftTrees = generateTrees(start, i - 1);
                // 获取所有的右子树
                List<TreeNode> rightTrees = generateTrees(i + 1, end);
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        // 创建根节点，左右节点依次赋值
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
