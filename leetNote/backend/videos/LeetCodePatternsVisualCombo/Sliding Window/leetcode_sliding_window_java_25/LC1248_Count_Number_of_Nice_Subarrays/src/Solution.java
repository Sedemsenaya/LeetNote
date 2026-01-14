public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if ((nums[r] & 1) == 1) k--;
            while (k < 0) {
                if ((nums[l++] & 1) == 1) k++;
            }
            ans += r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubarrays(new int[]{1,1,2,1,1}, 3)); // 2
    }
}
