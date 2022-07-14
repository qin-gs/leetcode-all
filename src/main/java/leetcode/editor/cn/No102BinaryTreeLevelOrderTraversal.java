// 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
// 输入：root = [1]
// 输出：[[1]]
//
//
// 示例 3：
//
//
// 输入：root = []
// 输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 广度优先搜索 二叉树 👍 1388 👎 0


package leetcode.editor.cn;

import java.util.*;

public class No102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new No102BinaryTreeLevelOrderTraversal().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = stack.poll();
                    level.add(pop.val);
                    if (pop.left != null) {
                        stack.add(pop.left);
                    }
                    if (pop.right != null) {
                        stack.add(pop.right);
                    }
                }
                ans.add(new ArrayList<>(level));
                level.clear();
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
