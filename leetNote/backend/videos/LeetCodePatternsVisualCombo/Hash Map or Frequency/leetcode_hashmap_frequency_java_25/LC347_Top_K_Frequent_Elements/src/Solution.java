import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // min-heap by freq
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) ans[i] = pq.poll()[0];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
    }
}
