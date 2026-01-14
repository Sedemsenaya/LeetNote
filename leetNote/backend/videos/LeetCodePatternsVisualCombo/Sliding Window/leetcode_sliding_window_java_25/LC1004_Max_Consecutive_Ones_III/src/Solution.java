public class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0, best = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;
            while (zeros > k) {
                if (nums[l++] == 0) zeros--;
            }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); // 6
    }
}
