public class Solution {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // for odd length, skip middle
        if (fast != null) slow = slow.next;

        ListNode second = reverse(slow);
        ListNode p1 = head, p2 = second;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
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

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(build(new int[]{1,2,2,1}))); // true
        System.out.println(new Solution().isPalindrome(build(new int[]{1,2})));     // false
    }
}
