import java.util.*;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, -1);
        int sum = 0, best = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (first.containsKey(sum)) best = Math.max(best, i - first.get(sum));
            else first.put(sum, i);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{0,1,0})); // 2
    }
}
