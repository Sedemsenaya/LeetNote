public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, best = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                best = Math.min(best, r - l + 1);
                sum -= nums[l++];
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
    }
}
