import java.util.*;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            cur = st.pop();
            if (--k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
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
        TreeNode root = build(new Integer[]{3,1,4,null,2});
        System.out.println(new Solution().kthSmallest(root, 1)); // 1
    }
}
