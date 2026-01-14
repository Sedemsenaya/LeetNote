public class Solution {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        k %= n;
        if (k == 0) return head;

        // make circular
        tail.next = head;
        int stepsToNewTail = n - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
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
        head = new Solution().rotateRight(head, 2);
        print(head); // 4->5->1->2->3
    }
}
