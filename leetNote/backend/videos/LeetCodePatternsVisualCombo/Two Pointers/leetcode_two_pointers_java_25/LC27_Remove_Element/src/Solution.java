import java.util.*;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int w = 0;
        for (int x : nums) if (x != val) nums[w++] = x;
        return w;
    }

    public static void main(String[] args) {
        int[] a = {3,2,2,3};
        int k = new Solution().removeElement(a, 3);
        System.out.println(k + " " + Arrays.toString(Arrays.copyOf(a, k))); // 2 [2,2]
    }
}
