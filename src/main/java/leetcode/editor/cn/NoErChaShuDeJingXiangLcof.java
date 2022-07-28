// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
// 1 3 6 9
// 镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
// 9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 284 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class NoErChaShuDeJingXiangLcof {
    public static void main(String[] args) {
        Solution solution = new NoErChaShuDeJingXiangLcof().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode ans = root.left;
            root.left = root.right;
            root.right = ans;
            mirrorTree(root.left);
            mirrorTree(root.right);
            return root;
        }

        public TreeNode mirrorTree2(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode pop = stack.pop();
                TreeNode tmp = pop.left;
                pop.left = pop.right;
                pop.right = tmp;
                if (pop.left != null) {
                    stack.push(pop.left);
                }
                if (pop.right != null) {
                    stack.push(pop.right);
                }
            }
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
