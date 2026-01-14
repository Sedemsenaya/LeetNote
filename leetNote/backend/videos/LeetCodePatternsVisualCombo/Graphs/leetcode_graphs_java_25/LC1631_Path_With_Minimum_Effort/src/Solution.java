import java.util.*;

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,0,0}); // effort, r, c

        int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int eff = cur[0], r = cur[1], c = cur[2];
            if (r == m-1 && c == n-1) return eff;
            if (eff != dist[r][c]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int w = Math.abs(heights[nr][nc] - heights[r][c]);
                int ne = Math.max(eff, w);
                if (ne < dist[nr][nc]) {
                    dist[nr][nc] = ne;
                    pq.add(new int[]{ne, nr, nc});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] h = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new Solution().minimumEffortPath(h)); // 2
    }
}
