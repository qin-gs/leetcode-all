// 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
//
// 示例 1：
//
//
// 输入：root = [1,2,3,null,5]
// 输出：["1->2->5","1->3"]
//
//
// 示例 2：
//
//
// 输入：root = [1]
// 输出：["1"]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 764 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new No257BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        List<String> ans = solution.binaryTreePaths(root);
        System.out.println(ans);
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * <pre>
     *
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
        public List<String> binaryTreePaths(TreeNode root) {
            ArrayList<String> ans = new ArrayList<>();
            binaryTreePaths(root, ans, "");
            return ans;
        }

        public void binaryTreePaths(TreeNode root, List<String> ans, String tmp) {
            if (root == null) {
                return;
            }
            // 直接把节点的值加上去
            tmp = tmp + root.val;
            // 如果是叶子节点
            if (root.left == null && root.right == null) {
                ans.add(tmp);
            } else {
                // 把 -> 添加到字符串末尾，否则结果会以 -> 开头
                binaryTreePaths(root.left, ans, tmp + "->");
                binaryTreePaths(root.right, ans, tmp + "->");
            }

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
