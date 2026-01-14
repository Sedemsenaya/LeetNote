public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] seen = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                count++;
                dfs(isConnected, i, seen);
            }
        }
        return count;
    }

    private void dfs(int[][] g, int u, boolean[] seen) {
        seen[u] = true;
        for (int v = 0; v < g.length; v++) {
            if (g[u][v] == 1 && !seen[v]) dfs(g, v, seen);
        }
    }

    public static void main(String[] args) {
        int[][] g = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new Solution().findCircleNum(g)); // 2
    }
}
