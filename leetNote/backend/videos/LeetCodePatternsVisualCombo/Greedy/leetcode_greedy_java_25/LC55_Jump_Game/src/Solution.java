public class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > far) return false;
            far = Math.max(far, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2,3,1,1,4})); // true
        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4})); // false
    }
}
