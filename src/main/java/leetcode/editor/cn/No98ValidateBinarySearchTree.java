// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
// 输入：root = [2,1,3]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：root = [5,1,4,null,null,3,6]
// 输出：false
// 解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1722 👎 0


package leetcode.editor.cn;

public class No98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new No98ValidateBinarySearchTree().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 3 比 5 小，但是在右侧，所以不是个二叉搜索树
         * <pre>
         *      5
         *  4      6
         *        3  7
         * </pre>
         */
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        private boolean isValidBST(TreeNode root, int max, int min) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.val > max || root.val < min) {
                return false;
            }

            return isValidBST(root.left, root.val, min)
                    && isValidBST(root.right, max, root.val);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
