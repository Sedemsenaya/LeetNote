import java.util.*;

public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && (nums[l] & 1) == 0) l++;
            while (l < r && (nums[r] & 1) == 1) r--;
            int t = nums[l]; nums[l] = nums[r]; nums[r] = t;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{3,1,2,4}))); // [4,2,1,3] or similar
    }
}
