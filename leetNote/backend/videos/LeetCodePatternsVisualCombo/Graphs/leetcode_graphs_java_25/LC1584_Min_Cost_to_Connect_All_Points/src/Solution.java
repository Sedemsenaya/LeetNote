import java.util.*;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] used = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (u == -1 || minDist[j] < minDist[u])) u = j;
            }
            used[u] = true;
            ans += minDist[u];

            for (int v = 0; v < n; v++) {
                if (used[v]) continue;
                int w = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                if (w < minDist[v]) minDist[v] = w;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] pts = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(new Solution().minCostConnectPoints(pts)); // 20
    }
}
