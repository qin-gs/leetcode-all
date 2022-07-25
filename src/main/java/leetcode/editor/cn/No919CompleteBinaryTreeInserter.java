// 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
//
// 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
//
// 实现 CBTInserter 类:
//
//
// CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
// CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态
//，并返回插入节点 TreeNode 的父节点的值；
// CBTInserter.get_root() 将返回树的头节点。
//
//
//
//
//
//
//
// 示例 1：
//
//
//
//
// 输入
//["CBTInserter", "insert", "insert", "get_root"]
//[[[1, 2]], [3], [4], []]
// 输出
//[null, 1, 2, [1, 2, 3, 4]]
//
// 解释
// CBTInserter cBTInserter = new CBTInserter([1, 2]);
// cBTInserter.insert(3);  // 返回 1
// cBTInserter.insert(4);  // 返回 2
// cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
//
//
//
// 提示：
//
//
// 树中节点数量范围为 [1, 1000]
// 0 <= Node.val <= 5000
// root 是完全二叉树
// 0 <= val <= 5000
// 每个测试用例最多调用 insert 和 get_root 操作 10⁴ 次
//
// Related Topics 树 广度优先搜索 设计 二叉树 👍 124 👎 0


package leetcode.editor.cn;

import java.util.*;

public class No919CompleteBinaryTreeInserter {
    public static void main(String[] args) {
        // Solution solution = new No919CompleteBinaryTreeInserter().new Solution();
        CBTInserter inserter = new No919CompleteBinaryTreeInserter().new CBTInserter(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null)));
        inserter.insert(7);
        inserter.insert(8);
        TreeNode root = inserter.get_root();
        System.out.println(root);

    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class CBTInserter {

        TreeNode root;
        Queue<TreeNode> queue = new LinkedList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            // 层次遍历记录所有可以插入的节点
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = q.poll();
                    if (pop.left != null) {
                        q.add(pop.left);
                    }
                    if (pop.right != null) {
                        q.add(pop.right);
                    }
                    if (pop.left == null || pop.right == null) {
                        queue.add(pop);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode pop = queue.peek();
            TreeNode node = new TreeNode(val);
            if (pop.left == null) {
                pop.left = node;
            } else {
                pop.right = node;
                queue.poll();
            }
            queue.add(node);
            return pop.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(val);
     * TreeNode param_2 = obj.get_root();
     */
    // leetcode submit region end(Prohibit modification and deletion)

}
