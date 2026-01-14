public class Solution {
    public int longestSubarray(int[] nums) {
        int zeros = 0, best = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;
            while (zeros > 1) {
                if (nums[l++] == 0) zeros--;
            }
            best = Math.max(best, r - l); // delete one element => window length -1
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{1,1,0,1})); // 3
    }
}
