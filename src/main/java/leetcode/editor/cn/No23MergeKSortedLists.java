// 给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
// 输出：[1,1,2,3,4,4,5,6]
// 解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
// 将它们合并到一个有序链表中得到。
// 1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
// 输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
// 输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2092 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class No23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new No23MergeKSortedLists().new Solution();
        ListNode first = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode third = new ListNode(2, new ListNode(6));
        ListNode ans = solution.mergeKLists(new ListNode[]{first, second, third});
        ListNode.printListNode(ans);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummyNode = new ListNode();
            ListNode head = dummyNode;
            int min = Integer.MAX_VALUE;
            int index = 0;

            // 如果还没有完成
            while (!isFinished(lists)) {
                // 找到 k 个链表中最小的节点
                for (int i = 0; i < lists.length; i++) {
                    // 可能有的链表比较短，已经到末尾了为 null
                    if (lists[i] != null) {
                        if (lists[i].val < min) {
                            min = lists[i].val;
                            index = i;
                        }
                    }
                }
                // 把最小的节点加上去
                head.next = new ListNode(lists[index].val);
                lists[index] = lists[index].next;
                head = head.next;
                // min 也需要修改
                min = Integer.MAX_VALUE;
            }

            return dummyNode.next;
        }

        /**
         * 判断一下是否合并完了
         */
        public boolean isFinished(ListNode[] lists) {
            return Arrays.stream(lists).noneMatch(Objects::nonNull);
        }

        /**
         * 优先队列
         */
        public ListNode mergeKLists2(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }

            ListNode dummyNode = new ListNode();
            ListNode root = dummyNode;
            while (!queue.isEmpty()) {
                ListNode poll = queue.poll();
                root.next = poll;
                root = root.next;
                if (poll.next != null) {
                    queue.add(poll.next);
                }
            }
            return dummyNode.next;
        }

        /**
         * 分治
         */
        public ListNode mergeKLists3(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        /**
         * 合并两个
         */
        private ListNode mergeTwoList(ListNode left, ListNode right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            ListNode dummyNode = new ListNode();
            ListNode tail = dummyNode;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
                tail = tail.next;
            }
            if (left != null) {
                tail.next = left;
            }
            if (right != null) {
                tail.next = right;
            }
            return dummyNode.next;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
