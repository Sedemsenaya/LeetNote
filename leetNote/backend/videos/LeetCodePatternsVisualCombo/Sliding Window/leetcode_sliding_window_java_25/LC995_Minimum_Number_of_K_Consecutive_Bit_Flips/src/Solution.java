public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int flips = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            flips ^= diff[i];
            int bit = nums[i] ^ flips;
            if (bit == 0) {
                if (i + k > n) return -1;
                ans++;
                flips ^= 1;
                diff[i + k] ^= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minKBitFlips(new int[]{0,1,0}, 1)); // 2
    }
}
