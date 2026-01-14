import java.util.*;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> ab = new HashMap<>();
        for (int a : nums1) for (int b : nums2) ab.put(a + b, ab.getOrDefault(a + b, 0) + 1);

        int ans = 0;
        for (int c : nums3) for (int d : nums4) ans += ab.getOrDefault(-(c + d), 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2}, b = {-2,-1}, c = {-1,2}, d = {0,2};
        System.out.println(new Solution().fourSumCount(a,b,c,d)); // 2
    }
}
