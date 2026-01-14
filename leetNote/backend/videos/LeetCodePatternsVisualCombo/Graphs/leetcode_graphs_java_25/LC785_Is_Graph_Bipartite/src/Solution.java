import java.util.*;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 uncolored, 1, -1
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            color[i] = 1;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (color[v] == 0) {
                        color[v] = -color[u];
                        q.add(v);
                    } else if (color[v] == color[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] g1 = {{1,3},{0,2},{1,3},{0,2}};
        int[][] g2 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(new Solution().isBipartite(g1)); // true
        System.out.println(new Solution().isBipartite(g2)); // false
    }
}
