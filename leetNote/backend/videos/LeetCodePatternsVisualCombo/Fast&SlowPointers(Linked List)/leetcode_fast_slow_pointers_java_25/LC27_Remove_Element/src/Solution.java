import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) nums[slow++] = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int k = new Solution().removeElement(nums, 3);
        System.out.println(k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k))); // [2,2]
    }
}
