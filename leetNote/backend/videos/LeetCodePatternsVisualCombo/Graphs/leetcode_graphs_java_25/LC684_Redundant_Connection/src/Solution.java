import java.util.*;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for (int[] e : edges) {
            if (!dsu.union(e[0], e[1])) return e;
        }
        return new int[0];
    }

    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n]; r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) {
            while (p[x] != x) { p[x] = p[p[x]]; x = p[x]; }
            return x;
        }
        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (r[pa] < r[pb]) p[pa] = pb;
            else if (r[pa] > r[pb]) p[pb] = pa;
            else { p[pb] = pa; r[pa]++; }
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(new Solution().findRedundantConnection(edges))); // [2,3]
    }
}
