// LeetCode 213: House Robber II (Bottom-up DP on two ranges)
public class Main {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robLine(nums, 0, n - 2),
                robLine(nums, 1, n - 1));
    }

    private static int robLine(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 0) return 0;
        if (n == 1) return nums[start];
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));    // 3
        System.out.println(rob(new int[]{1,2,3,1}));  // 4
    }
}
