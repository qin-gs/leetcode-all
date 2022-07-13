// 给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：root = [1,2,2,3,3,null,null,4,4]
// 输出：false
//
//
// 示例 3：
//
//
// 输入：root = []
// 输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -10⁴ <= Node.val <= 10⁴
//
// Related Topics 树 深度优先搜索 二叉树 👍 1065 👎 0


package leetcode.editor.cn;

public class No110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new No110BalancedBinaryTree().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 先判断子树的深度
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            // 递归判断子树是不是平衡的
            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
