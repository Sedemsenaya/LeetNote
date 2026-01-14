import java.util.*;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int best = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while ((long) nums[r] * (r - l + 1) - sum > k) {
                sum -= nums[l++];
            }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxFrequency(new int[]{1,2,4}, 5)); // 3
    }
}
