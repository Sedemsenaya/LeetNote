import java.util.*;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int w = 0;
        for (int x : nums) {
            if (w < 2 || x != nums[w - 2]) nums[w++] = x;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,1,2,3,3};
        int k = new Solution().removeDuplicates(a);
        System.out.println(k + " " + Arrays.toString(Arrays.copyOf(a, k))); // 7 [0,0,1,1,2,3,3]
    }
}
