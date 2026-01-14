public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) up = down + 1;
            else if (nums[i] < nums[i - 1]) down = up + 1;
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1,7,4,9,2,5})); // 6
    }
}
