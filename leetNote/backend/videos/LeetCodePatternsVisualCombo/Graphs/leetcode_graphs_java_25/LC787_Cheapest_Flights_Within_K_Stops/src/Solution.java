import java.util.*;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 1_000_000_000;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] nd = dist.clone();
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (dist[u] == INF) continue;
                nd[v] = Math.min(nd[v], dist[u] + w);
            }
            dist = nd;
        }
        return dist[dst] >= INF ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(new Solution().findCheapestPrice(3, flights, 0, 2, 1)); // 200
    }
}
