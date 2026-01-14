import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] deg = new int[n];
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
            deg[e[0]]++; deg[e[1]]++;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (deg[i] == 1) q.add(i);

        int remaining = n;
        while (remaining > 2) {
            int sz = q.size();
            remaining -= sz;
            for (int i = 0; i < sz; i++) {
                int leaf = q.poll();
                for (int nei : g.get(leaf)) {
                    if (--deg[nei] == 1) q.add(nei);
                }
            }
        }
        return new ArrayList<>(q);
    }

    public static void main(String[] args) {
        int[][] edges = {{1,0},{1,2},{1,3}};
        System.out.println(new Solution().findMinHeightTrees(4, edges)); // [1]
    }
}
