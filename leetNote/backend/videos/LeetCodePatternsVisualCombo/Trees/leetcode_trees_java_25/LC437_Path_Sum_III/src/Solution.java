import java.util.*;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(0L, 1);
        return dfs(root, 0L, targetSum, freq);
    }

    private int dfs(TreeNode n, long prefix, int target, Map<Long, Integer> freq) {
        if (n == null) return 0;
        prefix += n.val;
        int ans = freq.getOrDefault(prefix - target, 0);
        freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        ans += dfs(n.left, prefix, target, freq);
        ans += dfs(n.right, prefix, target, freq);
        freq.put(prefix, freq.get(prefix) - 1);
        if (freq.get(prefix) == 0) freq.remove(prefix);
        return ans;
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
        TreeNode root = build(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(new Solution().pathSum(root, 8)); // 3
    }
}
