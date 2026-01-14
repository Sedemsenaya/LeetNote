import java.util.*;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    }

    private void dfs(int[][] g, int u, List<Integer> path, List<List<Integer>> res) {
        int n = g.length;
        if (u == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int v : g[u]) {
            path.add(v);
            dfs(g, v, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] g = {{1,2},{3},{3},{}};
        System.out.println(new Solution().allPathsSourceTarget(g)); // [[0,1,3],[0,2,3]]
    }
}
