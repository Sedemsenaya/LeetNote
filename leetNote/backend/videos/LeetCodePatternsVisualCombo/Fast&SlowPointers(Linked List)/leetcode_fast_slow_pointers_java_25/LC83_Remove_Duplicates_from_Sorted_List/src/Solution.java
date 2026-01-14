public class Solution {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }

    static ListNode build(int[] a) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int x : a) { cur.next = new ListNode(x); cur = cur.next; }
        return dummy.next;
    }
    static void print(ListNode head) {
        for (ListNode c = head; c != null; c = c.next) {
            System.out.print(c.val + (c.next == null ? "\n" : "->"));
        }
    }

    public static void main(String[] args) {
        ListNode head = build(new int[]{1,1,2,3,3});
        print(new Solution().deleteDuplicates(head)); // 1->2->3
    }
}
