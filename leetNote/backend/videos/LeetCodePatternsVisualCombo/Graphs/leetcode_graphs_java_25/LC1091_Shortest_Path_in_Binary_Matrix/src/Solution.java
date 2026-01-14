import java.util.*;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        dist[0][0] = 1;
        int[] dr = {1,1,1,0,0,-1,-1,-1};
        int[] dc = {1,0,-1,1,-1,1,0,-1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == n-1 && c == n-1) return dist[r][c];
            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (grid[nr][nc] == 1 || dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr,nc});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] g = {{0,1},{1,0}};
        System.out.println(new Solution().shortestPathBinaryMatrix(g)); // 2
    }
}
