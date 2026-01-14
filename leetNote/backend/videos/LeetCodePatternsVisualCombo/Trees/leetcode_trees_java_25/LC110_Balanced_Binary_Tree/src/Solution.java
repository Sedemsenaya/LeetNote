public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode n) {
        if (n == null) return 0;
        int lh = height(n.left);
        if (lh == -1) return -1;
        int rh = height(n.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

    // ---------- Helpers for local testing ----------
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // Build a binary tree from level-order array where nulls are allowed.
    static TreeNode build(Integer[] a) {
        if (a == null || a.length == 0 || a[0] == null) return null;
        TreeNode[] nodes = new TreeNode[a.length];
        for (int i = 0; i < a.length; i++) if (a[i] != null) nodes[i] = new TreeNode(a[i]);
        for (int i = 0; i < a.length; i++) {
            if (nodes[i] == null) continue;
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l < a.length) nodes[i].left = nodes[l];
            if (r < a.length) nodes[i].right = nodes[r];
        }
        return nodes[0];
    }

    static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode a = build(new Integer[]{3,9,20,null,null,15,7});
        TreeNode b = build(new Integer[]{1,2,2,3,3,null,null,4,4});
        System.out.println(new Solution().isBalanced(a)); // true
        System.out.println(new Solution().isBalanced(b)); // false
    }
}
