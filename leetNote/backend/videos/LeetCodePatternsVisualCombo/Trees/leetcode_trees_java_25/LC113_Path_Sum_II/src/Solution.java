import java.util.*;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode n, int rem, List<Integer> path, List<List<Integer>> res) {
        if (n == null) return;
        path.add(n.val);
        rem -= n.val;
        if (n.left == null && n.right == null) {
            if (rem == 0) res.add(new ArrayList<>(path));
        } else {
            dfs(n.left, rem, path, res);
            dfs(n.right, rem, path, res);
        }
        path.remove(path.size() - 1);
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
        TreeNode root = build(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(new Solution().pathSum(root, 22));
    }
}
