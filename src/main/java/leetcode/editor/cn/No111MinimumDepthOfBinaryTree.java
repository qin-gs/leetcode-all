//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 10⁵] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 779 👎 0


package leetcode.editor.cn;

public class No111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new No111MinimumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int i = solution.minDepth(root);
        System.out.println("i = " + i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 如果是叶子节点返回 1
            if (root.left == null && root.right == null) {
                return 1;
            }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            // 如果其中一个叶子节点为 null，说明值为 0
            if (root.left == null || root.right == null) {
                return left + right + 1;
            }
            return Math.min(left, right) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
