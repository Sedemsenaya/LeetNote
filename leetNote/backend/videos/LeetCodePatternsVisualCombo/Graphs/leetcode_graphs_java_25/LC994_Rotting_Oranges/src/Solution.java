import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) q.add(new int[]{r,c});
                else if (grid[r][c] == 1) fresh++;
            }
        }
        int minutes = 0;
        int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = cur[0] + dr[k], nc = cur[1] + dc[k];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    fresh--;
                    q.add(new int[]{nr,nc});
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] g = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new Solution().orangesRotting(g)); // 4
    }
}
