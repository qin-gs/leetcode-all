// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5], n = 2
// 输出：[1,2,3,5]
//
//
// 示例 2：
//
//
// 输入：head = [1], n = 1
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：head = [1,2], n = 1
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针 👍 2165 👎 0


package leetcode.editor.cn;

public class No19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new No19RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode listNode = solution.removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            // 让 slow 指针停到要删除的前一个节点
            // [1] 1 这种清空不会出现空指针
            ListNode fast = dummyNode, slow = dummyNode;
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            // 删除 slow 的下一个节点
            slow.next = slow.next.next;
            return dummyNode.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
