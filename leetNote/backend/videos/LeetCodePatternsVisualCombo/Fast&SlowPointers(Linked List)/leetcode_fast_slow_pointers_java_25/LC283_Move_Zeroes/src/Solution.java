import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) nums[slow++] = nums[fast];
        }
        while (slow < nums.length) nums[slow++] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // [1,3,12,0,0]
    }
}
