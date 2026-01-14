public class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sr = 0, sc = 0, empty = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) { sr = r; sc = c; }
                if (grid[r][c] != -1) empty++;
            }
        }
        return dfs(grid, sr, sc, empty);
    }

    private int dfs(int[][] g, int r, int c, int remain) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == -1) return 0;
        if (g[r][c] == 2) return remain == 1 ? 1 : 0;

        int tmp = g[r][c];
        g[r][c] = -1;
        int ans = dfs(g, r + 1, c, remain - 1)
                + dfs(g, r - 1, c, remain - 1)
                + dfs(g, r, c + 1, remain - 1)
                + dfs(g, r, c - 1, remain - 1);
        g[r][c] = tmp;
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(new Solution().uniquePathsIII(grid)); // 2
    }
}
