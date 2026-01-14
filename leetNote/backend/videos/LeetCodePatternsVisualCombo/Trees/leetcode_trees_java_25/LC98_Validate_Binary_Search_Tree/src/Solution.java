public class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode n, Integer low, Integer high) {
        if (n == null) return true;
        if (low != null && n.val <= low) return false;
        if (high != null && n.val >= high) return false;
        return valid(n.left, low, n.val) && valid(n.right, n.val, high);
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
        System.out.println(new Solution().isValidBST(build(new Integer[]{2,1,3}))); // true
        System.out.println(new Solution().isValidBST(build(new Integer[]{5,1,4,null,null,3,6}))); // false
    }
}
