// 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
// 个。
//
// 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
//
// 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
//
// 如果第二小的值不存在的话，输出 -1 。
//
//
//
// 示例 1：
//
//
// 输入：root = [2,2,5,null,null,5,7]
// 输出：5
// 解释：最小的值是 2 ，第二小的值是 5 。
//
//
// 示例 2：
//
//
// 输入：root = [2,2,2]
// 输出：-1
// 解释：最小的值是 2, 但是不存在第二小的值。
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 25] 内
// 1 <= Node.val <= 2³¹ - 1
// 对于树中每个节点 root.val == min(root.left.val, root.right.val)
//
// Related Topics 树 深度优先搜索 二叉树 👍 269 👎 0


package leetcode.editor.cn;

public class No671SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new No671SecondMinimumNodeInABinaryTree().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            return getMin(root, root.val);
        }

        private int getMin(TreeNode root, int val) {
            if (root == null) {
                return -1;
            }
            // 如果当前节点的值大于 val，这个节点就不用继续遍历了
            if (root.val > val) {
                return root.val;
            }
            int left = getMin(root.left, val);
            int right = getMin(root.right, val);
            // 如果两个子树，都有小于 val 的节点，选小的那个
            if (left != -1 && right != -1) {
                return Math.min(left, right);
            } else {
                // 如果只有一个子树有小于 val 的节点
                return Math.max(left, right);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
