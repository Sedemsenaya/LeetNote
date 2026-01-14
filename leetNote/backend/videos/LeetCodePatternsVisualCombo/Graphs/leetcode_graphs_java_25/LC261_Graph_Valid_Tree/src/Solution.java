public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        DSU dsu = new DSU(n);
        for (int[] e : edges) {
            if (!dsu.union(e[0], e[1])) return false;
        }
        return true;
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
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(new Solution().validTree(5, edges)); // true
    }
}
