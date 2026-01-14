import java.util.*;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        boolean[] seen = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                count++;
                dfs(g, i, seen);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> g, int u, boolean[] seen) {
        seen[u] = true;
        for (int v : g.get(u)) if (!seen[v]) dfs(g, v, seen);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(new Solution().countComponents(5, edges)); // 2
    }
}
