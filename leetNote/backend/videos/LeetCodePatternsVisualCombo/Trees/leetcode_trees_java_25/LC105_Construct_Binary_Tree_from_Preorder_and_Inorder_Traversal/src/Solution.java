import java.util.*;

public class Solution {
    private int pi = 0;
    private Map<Integer, Integer> inPos;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inPos = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inPos.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int lo, int hi) {
        if (lo > hi) return null;
        int val = pre[pi++];
        TreeNode root = new TreeNode(val);
        int mid = inPos.get(val);
        root.left = build(pre, lo, mid - 1);
        root.right = build(pre, mid + 1, hi);
        return root;
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
        int[] pre = {3,9,20,15,7};
        int[] in  = {9,3,15,20,7};
        TreeNode root = new Solution().buildTree(pre, in);
        printInorder(root); // 9 3 15 20 7
        System.out.println();
    }
}
