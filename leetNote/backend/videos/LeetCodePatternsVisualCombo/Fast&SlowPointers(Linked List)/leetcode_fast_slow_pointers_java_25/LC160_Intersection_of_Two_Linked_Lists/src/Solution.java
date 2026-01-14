public class Solution {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        // A: 4->1->8->4->5
        // B: 5->6->1->8->4->5  (intersect at 8)
        ListNode i1 = new ListNode(8);
        i1.next = new ListNode(4);
        i1.next.next = new ListNode(5);

        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = i1;

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(1);
        b.next.next.next = i1;

        ListNode inter = new Solution().getIntersectionNode(a, b);
        System.out.println(inter == null ? "null" : inter.val); // 8
    }
}
