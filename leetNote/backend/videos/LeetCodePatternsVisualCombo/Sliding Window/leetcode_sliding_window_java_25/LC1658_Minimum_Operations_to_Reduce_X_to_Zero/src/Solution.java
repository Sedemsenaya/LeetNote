public class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int v : nums) total += v;
        int target = total - x;
        if (target == 0) return nums.length;

        int sum = 0, best = -1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (l <= r && sum > target) sum -= nums[l++];
            if (sum == target) best = Math.max(best, r - l + 1);
        }
        return best == -1 ? -1 : nums.length - best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{1,1,4,2,3}, 5)); // 2
    }
}
