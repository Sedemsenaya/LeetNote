// LeetCode 53: Maximum Subarray (bottom-up DP / Kadane)
public class Main {

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int best = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(
                new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
    }
}
