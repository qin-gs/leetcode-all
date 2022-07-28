// 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
// 给定的树 A:
//
// 3
// / \
// 4 5
// / \
// 1 2
// 给定的树 B：
//
// 4
// /
// 1
// 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
// 示例 1：
//
// 输入：A = [1,2,3], B = [3,1]
// 输出：false
//
//
// 示例 2：
//
// 输入：A = [3,4,5,1,2], B = [4,1]
// 输出：true
//
// 限制：
//
// 0 <= 节点个数 <= 10000
// Related Topics 树 深度优先搜索 二叉树 👍 602 👎 0


package leetcode.editor.cn;

public class NoShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new NoShuDeZiJieGouLcof().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return isSame(A, B)
                    || isSubStructure(A.left, B.left)
                    || isSubStructure(A.right, B.right);
        }

        /**
         * 判断 b 是不是 a 的子树
         */
        public boolean isSame(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }
            if (a == null) {
                return false;
            }
            if (a.val == b.val) {
                return isSame(a.left, b.left)
                        && isSame(a.right, b.right);
            }
            return false;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
