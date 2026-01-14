public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
        TreeNode root = build(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new Solution().maxDepth(root)); // 3
    }
}
