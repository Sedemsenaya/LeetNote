import java.util.*;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int sum = 0, ans = 0;
        for (int x : nums) {
            sum += x;
            ans += freq.getOrDefault(sum - k, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1,1,1}, 2)); // 2
    }
}
