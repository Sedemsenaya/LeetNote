public class Solution {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1) find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) reverse second half
        ListNode second = reverse(slow.next);
        slow.next = null;

        // 3) merge
        ListNode first = head;
        while (second != null) {
            ListNode t1 = first.next, t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
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
        new Solution().reorderList(head);
        print(head); // 1->5->2->4->3
    }
}
