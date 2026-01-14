import java.util.*;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length && k > 0 && nums[i] < 0) {
            nums[i] = -nums[i];
            i++; k--;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            sum += x;
            min = Math.min(min, x);
        }
        if (k % 2 == 1) sum -= 2 * min;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestSumAfterKNegations(new int[]{4,2,3}, 1)); // 5
    }
}
