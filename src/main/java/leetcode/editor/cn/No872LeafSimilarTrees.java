// 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//
//
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
//
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
//
//
//
// 示例 1：
//
//
//
//
// 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,
// null,null,null,null,9,8]
// 输出：true
//
//
// 示例 2：
//
//
//
//
// 输入：root1 = [1,2,3], root2 = [1,3,2]
// 输出：false
//
//
//
//
// 提示：
//
//
// 给定的两棵树结点数在 [1, 200] 范围内
// 给定的两棵树上的值在 [0, 200] 范围内
//
// Related Topics 树 深度优先搜索 二叉树 👍 191 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No872LeafSimilarTrees {
    public static void main(String[] args) {
        Solution solution = new No872LeafSimilarTrees().new Solution();
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            // 后序遍历
            List<Integer> first = getLeaf(root1, new ArrayList<>());
            List<Integer> second = getLeaf(root2, new ArrayList<>());
            if (first.size() != second.size()) {
                return false;
            }
            for (int i = 0; i < first.size(); i++) {
                if (!first.get(i).equals(second.get(i))) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 后序遍历
         */
        public List<Integer> getLeaf(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return ans;
            }
            // 如果是叶子节点加进去
            if (root.left == null && root.right == null) {
                ans.add(root.val);
            }
            getLeaf(root.left, ans);
            getLeaf(root.right, ans);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
