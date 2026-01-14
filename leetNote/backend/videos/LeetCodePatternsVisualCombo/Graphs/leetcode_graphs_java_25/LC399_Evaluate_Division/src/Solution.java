import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> g = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];
            g.computeIfAbsent(a, x -> new ArrayList<>()).add(new Edge(b, v));
            g.computeIfAbsent(b, x -> new ArrayList<>()).add(new Edge(a, 1.0 / v));
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s = queries.get(i).get(0), t = queries.get(i).get(1);
            if (!g.containsKey(s) || !g.containsKey(t)) { ans[i] = -1.0; continue; }
            if (s.equals(t)) { ans[i] = 1.0; continue; }
            ans[i] = bfs(g, s, t);
        }
        return ans;
    }

    static class Edge {
        String to; double w;
        Edge(String t, double w) { this.to = t; this.w = w; }
    }

    private double bfs(Map<String, List<Edge>> g, String s, String t) {
        ArrayDeque<String> q = new ArrayDeque<>();
        ArrayDeque<Double> valq = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.add(s); valq.add(1.0); seen.add(s);
        while (!q.isEmpty()) {
            String u = q.poll();
            double cur = valq.poll();
            if (u.equals(t)) return cur;
            for (Edge e : g.get(u)) {
                if (seen.add(e.to)) {
                    q.add(e.to);
                    valq.add(cur * e.w);
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        List<List<String>> eq = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c"));
        double[] vals = {2.0, 3.0};
        List<List<String>> q = Arrays.asList(Arrays.asList("a","c"), Arrays.asList("c","a"), Arrays.asList("a","e"), Arrays.asList("a","a"));
        System.out.println(Arrays.toString(new Solution().calcEquation(eq, vals, q))); // [6.0, 0.1666..., -1.0, 1.0]
    }
}
