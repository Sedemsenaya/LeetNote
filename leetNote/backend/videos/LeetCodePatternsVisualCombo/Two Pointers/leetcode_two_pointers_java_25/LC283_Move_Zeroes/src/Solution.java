import java.util.*;

public class Solution {
    public void moveZeroes(int[] nums) {
        int w = 0;
        for (int x : nums) if (x != 0) nums[w++] = x;
        while (w < nums.length) nums[w++] = 0;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        new Solution().moveZeroes(a);
        System.out.println(Arrays.toString(a)); // [1,3,12,0,0]
    }
}
