import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = new Solution().removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k))); // [0,1,2,3,4]
    }
}
