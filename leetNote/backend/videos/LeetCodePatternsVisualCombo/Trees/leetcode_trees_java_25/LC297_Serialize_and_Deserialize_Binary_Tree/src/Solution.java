import java.util.*;

public class Solution {
    static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode n = q.poll();
                if (n == null) {
                    sb.append("#,");
                    continue;
                }
                sb.append(n.val).append(',');
                q.add(n.left);
                q.add(n.right);
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            String[] parts = data.split(",");
            if (parts[0].equals("#")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            int i = 1;
            while (!q.isEmpty() && i < parts.length) {
                TreeNode cur = q.poll();
                if (i < parts.length && !parts[i].equals("#") && !parts[i].isEmpty()) {
                    cur.left = new TreeNode(Integer.parseInt(parts[i]));
                    q.add(cur.left);
                }
                i++;
                if (i < parts.length && !parts[i].equals("#") && !parts[i].isEmpty()) {
                    cur.right = new TreeNode(Integer.parseInt(parts[i]));
                    q.add(cur.right);
                }
                i++;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = build(new Integer[]{1,2,3,null,null,4,5});
        Codec c = new Codec();
        String s = c.serialize(root);
        TreeNode back = c.deserialize(s);
        printInorder(back);
        System.out.println();
    }

    // ---------- Helpers for local testing ----------
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

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
}
