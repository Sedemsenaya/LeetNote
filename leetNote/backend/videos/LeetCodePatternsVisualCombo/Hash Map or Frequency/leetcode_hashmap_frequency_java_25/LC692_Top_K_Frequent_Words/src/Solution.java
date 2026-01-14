import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) freq.put(w, freq.getOrDefault(w, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return Integer.compare(fa, fb);
            return b.compareTo(a);
        });

        for (String w : freq.keySet()) {
            pq.add(w);
            if (pq.size() > k) pq.poll();
        }

        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) res.addFirst(pq.poll());
        return res;
    }

    public static void main(String[] args) {
        String[] w = {"i","love","leetcode","i","love","coding"};
        System.out.println(new Solution().topKFrequent(w, 2)); // [i, love]
    }
}
