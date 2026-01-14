import java.util.*;

public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        int count = 0;
        for (int x : freq.keySet()) {
            if (k == 0) {
                if (freq.get(x) >= 2) count++;
            } else {
                if (freq.containsKey(x + k)) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[]{3,1,4,1,5}, 2)); // 2
        System.out.println(new Solution().findPairs(new int[]{1,2,3,4,5}, 1)); // 4
    }
}
