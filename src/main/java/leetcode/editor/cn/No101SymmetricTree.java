// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,2,2,3,4,4,3]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：root = [1,2,2,null,3,null,3]
// 输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1966 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class No101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new No101SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (q.size() > 0) {
            // 取出两个，这两个位置是对称的
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && root == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            // 放进去对称的两个
            q.add(left.left);
            q.add(right.right);

            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}
