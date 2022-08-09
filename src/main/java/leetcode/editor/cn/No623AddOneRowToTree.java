// 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
//
// 注意，根节点 root 位于深度 1 。
//
// 加法规则如下:
//
//
// 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
// cur 原来的左子树应该是新的左子树根的左子树。
// cur 原来的右子树应该是新的右子树根的右子树。
// 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
//
//
//
//
// 示例 1:
//
//
//
//
// 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
// 输出: [4,1,1,2,null,null,6,3,1,5]
//
// 示例 2:
//
//
//
//
// 输入: root = [4,2,null,3,1], val = 1, depth = 3
// 输出:  [4,2,null,1,1,3,null,null,1]
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 10⁴] 范围内
// 树的深度在 [1, 10⁴]范围内
// -100 <= Node.val <= 100
// -10⁵ <= val <= 10⁵
// 1 <= depth <= the depth of tree + 1
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 165 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class No623AddOneRowToTree {
    public static void main(String[] args) {
        Solution solution = new No623AddOneRowToTree().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        solution.addOneRow(root, 5, 4);
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {

            // 额外判断
            if (depth == 1) {
                TreeNode ans = new TreeNode(val);
                ans.left = root;
                return ans;
            }

            // 层次遍历，记录第 n-1 行的节点
            Queue<TreeNode> dept = new LinkedList<>();
            dept.add(root);
            while (depth - 1 > 1) { // 2
                int size = dept.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = dept.poll();
                    if (poll != null) {
                        if (poll.left != null) {
                            dept.add(poll.left);
                        }
                        if (poll.right != null) {
                            dept.add(poll.right);
                        }
                    }
                }
                depth--;
            }
            // 修改 n-1 行节点
            while (dept.size() > 0) {
                TreeNode poll = dept.poll();
                TreeNode tmpLeft = poll.left;
                TreeNode tmpRight = poll.right;

                poll.left = new TreeNode(val);
                poll.left.left = tmpLeft;

                poll.right = new TreeNode(val);
                poll.right.right = tmpRight;

            }
            return root;
        }

        /**
         * 递归
         */
        public TreeNode addOneRow2(TreeNode root, int val, int depth) {
            if (root == null) {
                return null;
            }
            if (depth == 1) {
                return new TreeNode(val, root, null);
            }
            if (depth == 2) {
                root.left = new TreeNode(val, root.left, null);
                root.right = new TreeNode(val, root.right, null);
            } else {
                addOneRow2(root.left, val, depth - 1);
                addOneRow2(root.right, val, depth - 1);
            }
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
