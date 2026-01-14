public class Solution {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
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
        ListNode head = build(new int[]{1,2,3,4,5});
        head = new Solution().removeNthFromEnd(head, 2);
        print(head); // 1->2->3->5
    }
}
