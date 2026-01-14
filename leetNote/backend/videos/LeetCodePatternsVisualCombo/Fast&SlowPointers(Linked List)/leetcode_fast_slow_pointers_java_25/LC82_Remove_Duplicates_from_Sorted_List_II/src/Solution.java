public class Solution {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int dup = head.val;
                while (head != null && head.val == dup) head = head.next;
                prev.next = head;
            } else {
                prev = head;
                head = head.next;
            }
        }
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
        ListNode head = build(new int[]{1,2,3,3,4,4,5});
        print(new Solution().deleteDuplicates(head)); // 1->2->5
    }
}
