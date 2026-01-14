public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int best = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) best = Math.max(best, dfs(grid, r, c));
            }
        }
        return best;
    }

    private int dfs(int[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == 0) return 0;
        g[r][c] = 0;
        return 1 + dfs(g, r + 1, c) + dfs(g, r - 1, c) + dfs(g, r, c + 1) + dfs(g, r, c - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,0,0},
            {1,1,1,0,0},
            {0,1,0,0,1}
        };
        System.out.println(new Solution().maxAreaOfIsland(grid)); // 6
    }
}
