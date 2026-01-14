import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        for (List<String> t : tickets) {
            g.computeIfAbsent(t.get(0), x -> new PriorityQueue<>()).add(t.get(1));
        }
        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", g, route);
        return route;
    }

    private void dfs(String u, Map<String, PriorityQueue<String>> g, LinkedList<String> route) {
        PriorityQueue<String> pq = g.get(u);
        while (pq != null && !pq.isEmpty()) {
            String v = pq.poll();
            dfs(v, g, route);
        }
        route.addFirst(u);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("MUC","LHR"),
            Arrays.asList("JFK","MUC"),
            Arrays.asList("SFO","SJC"),
            Arrays.asList("LHR","SFO")
        );
        System.out.println(new Solution().findItinerary(tickets)); // [JFK, MUC, LHR, SFO, SJC]
    }
}
