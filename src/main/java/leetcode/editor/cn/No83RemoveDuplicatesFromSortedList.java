// 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,1,2]
// 输出：[1,2]
//
//
// 示例 2：
//
//
// 输入：head = [1,1,2,3,3]
// 输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
// Related Topics 链表 👍 822 👎 0


package leetcode.editor.cn;

public class No83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new No83RemoveDuplicatesFromSortedList().new Solution();
        ListNode root = new ListNode(1, new ListNode(1, new ListNode(2)));
        solution.deleteDuplicates(root);
        System.out.println("root = " + root);
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            while (head != null && head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
            return dummyNode.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
