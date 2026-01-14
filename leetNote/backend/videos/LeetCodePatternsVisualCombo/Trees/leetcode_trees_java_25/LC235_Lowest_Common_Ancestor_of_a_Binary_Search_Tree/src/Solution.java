public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int a = p.val, b = q.val;
        TreeNode cur = root;
        while (cur != null) {
            if (a < cur.val && b < cur.val) cur = cur.left;
            else if (a > cur.val && b > cur.val) cur = cur.right;
            else return cur;
        }
        return null;
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

    static TreeNode find(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode l = find(root.left, val);
        return (l != null) ? l : find(root.right, val);
    }
    public static void main(String[] args) {
        TreeNode root = build(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeNode p = find(root, 2), q = find(root, 8);
        System.out.println(new Solution().lowestCommonAncestor(root, p, q).val); // 6
    }
}
