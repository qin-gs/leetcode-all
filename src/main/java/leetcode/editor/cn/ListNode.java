package leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(val);
        ListNode tmp = next;
        while (tmp != null) {
            sb.append(" -> ").append(tmp.val);
            tmp = tmp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
