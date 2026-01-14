public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int s) {
        if (s < 0) return 0;
        int sum = 0, ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum > s) sum -= nums[l++];
            ans += r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{1,0,1,0,1}, 2)); // 4
    }
}
