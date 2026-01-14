public class Solution {
    public void flatten(TreeNode root) {
        flattenTail(root);
    }

    private TreeNode flattenTail(TreeNode n) {
        if (n == null) return null;
        TreeNode leftTail = flattenTail(n.left);
        TreeNode rightTail = flattenTail(n.right);
        if (leftTail != null) {
            leftTail.right = n.right;
            n.right = n.left;
            n.left = null;
        }
        return rightTail != null ? rightTail : (leftTail != null ? leftTail : n);
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

    static void printRight(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        TreeNode root = build(new Integer[]{1,2,5,3,4,null,6});
        new Solution().flatten(root);
        printRight(root); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    }
}
