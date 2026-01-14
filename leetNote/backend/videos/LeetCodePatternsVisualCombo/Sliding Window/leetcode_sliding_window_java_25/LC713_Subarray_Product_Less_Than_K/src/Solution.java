public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        long prod = 1;
        int ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (prod >= k) prod /= nums[l++];
            ans += r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100)); // 8
    }
}
