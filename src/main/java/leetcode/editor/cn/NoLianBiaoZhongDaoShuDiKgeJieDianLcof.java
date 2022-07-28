// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
//
//
//
// 示例：
//
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
// 返回链表 4->5.
// Related Topics 链表 双指针 👍 380 👎 0


package leetcode.editor.cn;

public class NoLianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new NoLianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            // 1 2 3 4 5 6 7 倒数第 2 个是 6
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
