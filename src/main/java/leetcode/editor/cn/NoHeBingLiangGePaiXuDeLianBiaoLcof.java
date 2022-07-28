// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 递归 链表 👍 266 👎 0


package leetcode.editor.cn;

public class NoHeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new NoHeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode();
            ListNode curr = dummyNode;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if (l1 != null) {
                curr.next = l1;
            }
            if (l2 != null) {
                curr.next = l2;
            }
            return dummyNode.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
