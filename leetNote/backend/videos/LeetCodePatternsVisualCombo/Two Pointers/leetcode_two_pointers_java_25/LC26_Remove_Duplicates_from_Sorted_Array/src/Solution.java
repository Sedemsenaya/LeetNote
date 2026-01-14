import java.util.*;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int w = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[w - 1]) nums[w++] = nums[r];
        }
        return w;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        int k = new Solution().removeDuplicates(a);
        System.out.println(k + " " + Arrays.toString(Arrays.copyOf(a, k))); // 2 [1,2]
    }
}
