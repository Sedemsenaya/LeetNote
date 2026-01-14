import java.util.*;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pac);
            dfs(heights, r, n - 1, atl);
        }
        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pac);
            dfs(heights, m - 1, c, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pac[r][c] && atl[r][c]) res.add(Arrays.asList(r, c));
            }
        }
        return res;
    }

    private void dfs(int[][] h, int r, int c, boolean[][] seen) {
        if (seen[r][c]) return;
        seen[r][c] = true;
        int m = h.length, n = h[0].length;
        int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k], nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if (h[nr][nc] >= h[r][c]) dfs(h, nr, nc, seen);
        }
    }

    public static void main(String[] args) {
        int[][] h = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        System.out.println(new Solution().pacificAtlantic(h).size()); // 7
    }
}
